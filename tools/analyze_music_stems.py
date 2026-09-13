import os
import sys
import wave
import json
import math
import numpy as np
from scipy import signal
from scipy.fft import rfft, rfftfreq

def read_wav_24bit(file_path):
    with wave.open(file_path, "rb") as wf:
        n_channels = wf.getnchannels()
        sampwidth = wf.getsampwidth()
        framerate = wf.getframerate()
        n_frames = wf.getnframes()
        raw_bytes = wf.readframes(n_frames)

    # 24-bit PCM unpack
    if sampwidth == 3:
        # Convert 3-byte signed integers to numpy array
        total_samples = n_frames * n_channels
        # Unpack as bytearray
        a = np.frombuffer(raw_bytes, dtype=np.uint8)
        # Reshape to (total_samples, 3)
        a = a.reshape(-1, 3)
        # Pad with MSB sign bit
        padded = np.empty((len(a), 4), dtype=np.uint8)
        padded[:, :3] = a
        padded[:, 3] = np.where(a[:, 2] & 0x80, 0xFF, 0x00)
        samples_int = padded.view(np.int32).flatten()
        samples_float = samples_int.astype(np.float64) / 8388608.0
    elif sampwidth == 2:
        samples_int = np.frombuffer(raw_bytes, dtype=np.int16)
        samples_float = samples_int.astype(np.float64) / 32768.0
    else:
        raise ValueError(f"Unsupported bit depth (sampwidth={sampwidth})")

    if n_channels == 2:
        samples_float = samples_float.reshape(-1, 2)
        mono = np.mean(samples_float, axis=1)
    else:
        mono = samples_float

    return {
        "channels": n_channels,
        "sample_rate": framerate,
        "sample_count": n_frames,
        "duration": n_frames / float(framerate),
        "data_stereo": samples_float if n_channels == 2 else np.column_stack((mono, mono)),
        "data_mono": mono
    }

def compute_rms_peak(data):
    peak = np.max(np.abs(data))
    rms = np.sqrt(np.mean(data**2))
    peak_dbfs = 20 * math.log10(peak) if peak > 1e-9 else -120.0
    rms_dbfs = 20 * math.log10(rms) if rms > 1e-9 else -120.0
    return {
        "peak_linear": round(float(peak), 5),
        "peak_dbfs": round(float(peak_dbfs), 2),
        "rms_linear": round(float(rms), 5),
        "rms_dbfs": round(float(rms_dbfs), 2)
    }

def detect_onsets(mono, sr, hop_size=512, frame_size=2048):
    # Short-time Fourier transform for spectral flux onset detection
    f, t, Zxx = signal.stft(mono, fs=sr, nperseg=frame_size, noverlap=frame_size - hop_size)
    magnitude = np.abs(Zxx)
    
    # Half-wave rectified spectral flux
    diff = np.diff(magnitude, axis=1)
    flux = np.sum(np.maximum(0, diff), axis=0)
    
    # Normalize flux
    flux_max = np.max(flux) if np.max(flux) > 0 else 1.0
    flux_norm = flux / flux_max
    
    # Peak picking with threshold
    threshold = 0.15
    peaks, _ = signal.find_peaks(flux_norm, height=threshold, distance=int(0.1 * sr / hop_size))
    onset_times = t[peaks]
    
    return onset_times, flux_norm, t

def estimate_bpm_and_beats(onset_times, sr, duration, min_bpm=80, max_bpm=180):
    if len(onset_times) < 4:
        return 0.0, [], []
        
    intervals = np.diff(onset_times)
    # Filter valid inter-onset intervals corresponding to 60..200 BPM
    valid_ioi = intervals[(intervals >= 60.0 / max_bpm) & (intervals <= 60.0 / min_bpm)]
    
    if len(valid_ioi) == 0:
        # Try subdivisions
        valid_ioi = intervals[(intervals >= 30.0 / max_bpm) & (intervals <= 120.0 / min_bpm)]
        
    if len(valid_ioi) == 0:
        return 0.0, [], []
        
    # Histogram of intervals
    hist, bin_edges = np.histogram(valid_ioi, bins=50)
    best_interval = (bin_edges[np.argmax(hist)] + bin_edges[np.argmax(hist) + 1]) / 2.0
    
    bpm = 60.0 / best_interval
    # Normalize BPM around 110-160
    while bpm < 90:
        bpm *= 2
    while bpm > 180:
        bpm /= 2
        
    # Find downbeats / beats
    beat_interval = 60.0 / bpm
    first_onset = onset_times[0]
    expected_beats = np.arange(first_onset, duration, beat_interval)
    downbeats = expected_beats[0::4] # 4/4 meter
    
    return round(float(bpm), 2), [round(float(b), 4) for b in expected_beats[:16]], [round(float(db), 4) for db in downbeats[:8]]

def compute_spectral_features(mono, sr):
    # Compute FFT
    X = rfft(mono[:sr * 10]) # First 10 seconds
    freqs = rfftfreq(len(mono[:sr * 10]), 1.0 / sr)
    mag = np.abs(X)
    
    # Spectral Centroid
    total_mag = np.sum(mag)
    if total_mag > 0:
        centroid = float(np.sum(freqs * mag) / total_mag)
    else:
        centroid = 0.0
        
    # Spectral Rolloff (85%)
    cum_mag = np.cumsum(mag)
    rolloff_idx = np.searchsorted(cum_mag, 0.85 * total_mag)
    rolloff = float(freqs[min(rolloff_idx, len(freqs) - 1)])
    
    return {
        "spectral_centroid_hz": round(centroid, 1),
        "spectral_rolloff_85_hz": round(rolloff, 1)
    }

def estimate_chroma(mono, sr):
    # Simple 12-semitone pitch class energy profile
    # Target frequencies for A4 = 440 Hz (C, C#, D, D#, E, F, F#, G, G#, A, A#, B)
    notes = ["C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"]
    chroma_energy = np.zeros(12)
    
    X = rfft(mono)
    freqs = rfftfreq(len(mono), 1.0 / sr)
    mag = np.abs(X)
    
    for i in range(12):
        # Sum energy across octaves from 65Hz (C2) to 2093Hz (C7)
        semitone_offset = (i - 9) % 12 # A is index 9
        for octave in range(2, 7):
            f_center = 440.0 * (2.0 ** ((i - 9 + (octave - 4) * 12) / 12.0))
            if f_center < 50 or f_center > sr / 2:
                continue
            band = (freqs >= f_center * 0.97) & (freqs <= f_center * 1.03)
            chroma_energy[i] += np.sum(mag[band])
            
    norm = np.linalg.norm(chroma_energy)
    if norm > 0:
        chroma_norm = chroma_energy / norm
    else:
        chroma_norm = chroma_energy
        
    top_note_idx = int(np.argmax(chroma_norm))
    key_candidate = notes[top_note_idx]
    
    return {
        "chroma_profile": {notes[i]: round(float(chroma_norm[i]), 4) for i in range(12)},
        "predominant_pitch_class": key_candidate
    }

def analyze_all_stems():
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    music_dir = os.path.join(base_dir, "assets", "audio", "music")
    
    filenames = [
        "music_gameplay_base.wav",
        "music_gameplay_intensity.wav",
        "music_gameplay_danger.wav"
    ]
    
    results = {}
    audio_data = {}
    
    txt_lines = []
    txt_lines.append("=" * 70)
    txt_lines.append("CYBER NINJA RUNNER - MUSIC STEM QA & SYNCHRONIZATION ANALYSIS")
    txt_lines.append("=" * 70)
    txt_lines.append(f"Target specification: 138 BPM | D Minor | 4/4 | 16 Bars (27.826s, 1,335,652 samples)")
    txt_lines.append("-" * 70)
    
    for fn in filenames:
        path = os.path.join(music_dir, fn)
        if not os.path.exists(path):
            print(f"Error: {path} does not exist!")
            return 1
            
        print(f"Analyzing {fn}...")
        wav_info = read_wav_24bit(path)
        audio_data[fn] = wav_info
        
        levels = compute_rms_peak(wav_info["data_mono"])
        onsets, flux, t = detect_onsets(wav_info["data_mono"], wav_info["sample_rate"])
        bpm, beats, downbeats = estimate_bpm_and_beats(onsets, wav_info["sample_rate"], wav_info["duration"])
        spectral = compute_spectral_features(wav_info["data_mono"], wav_info["sample_rate"])
        chroma = estimate_chroma(wav_info["data_mono"], wav_info["sample_rate"])
        
        # Loop boundary test: compare start (0.05s) vs end (last 0.05s) and 16-bar point (27.826s)
        sr = wav_info["sample_rate"]
        mono = wav_info["data_mono"]
        target_16bar_samples = 1335652
        
        start_edge_amp = float(np.abs(mono[0]))
        end_edge_amp = float(np.abs(mono[-1]))
        bar16_edge_amp = float(np.abs(mono[min(target_16bar_samples, len(mono) - 1)]))
        
        results[fn] = {
            "filename": fn,
            "sample_rate": wav_info["sample_rate"],
            "channels": wav_info["channels"],
            "sample_count": wav_info["sample_count"],
            "duration_seconds": round(wav_info["duration"], 4),
            "levels": levels,
            "detected_onsets_count": len(onsets),
            "estimated_bpm": bpm,
            "first_downbeats_sec": downbeats,
            "spectral": spectral,
            "harmonic": chroma,
            "loop_boundary": {
                "start_sample_amp": round(start_edge_amp, 6),
                "end_sample_amp": round(end_edge_amp, 6),
                "sample_at_16bars_amp": round(bar16_edge_amp, 6),
                "exact_target_16bar_samples": target_16bar_samples,
                "file_exceeds_16bars_by_samples": wav_info["sample_count"] - target_16bar_samples
            }
        }
        
        txt_lines.append(f"\n[FILE: {fn}]")
        txt_lines.append(f"  Sample Rate:     {wav_info['sample_rate']} Hz | Channels: {wav_info['channels']} | Bit Depth: 24-bit")
        txt_lines.append(f"  Sample Count:    {wav_info['sample_count']} samples ({wav_info['duration']:.3f} s)")
        txt_lines.append(f"  Peak Level:      {levels['peak_dbfs']} dBFS (linear: {levels['peak_linear']})")
        txt_lines.append(f"  RMS Level:       {levels['rms_dbfs']} dBFS (linear: {levels['rms_linear']})")
        txt_lines.append(f"  Estimated BPM:   {bpm} BPM")
        txt_lines.append(f"  Dominant Pitch:  {chroma['predominant_pitch_class']}")
        txt_lines.append(f"  Spectral Center: {spectral['spectral_centroid_hz']} Hz | Rolloff 85%: {spectral['spectral_rolloff_85_hz']} Hz")
        txt_lines.append(f"  Detected Onsets: {len(onsets)} transients detected")
        txt_lines.append(f"  Loop Edges:      Start: {start_edge_amp:.5f}, End: {end_edge_amp:.5f}, @16-Bar Mark: {bar16_edge_amp:.5f}")

    # Inter-stem correlation & synchronization analysis
    txt_lines.append("\n" + "=" * 70)
    txt_lines.append("INTER-STEM SYNCHRONIZATION & CROSS-CORRELATION MATRIX")
    txt_lines.append("=" * 70)
    
    base_mono = audio_data["music_gameplay_base.wav"]["data_mono"]
    int_mono = audio_data["music_gameplay_intensity.wav"]["data_mono"]
    dan_mono = audio_data["music_gameplay_danger.wav"]["data_mono"]
    
    # Compute normalized cross-correlation on envelope/signal
    def compute_similarity(sig1, sig2):
        # Pearson correlation coefficient on signal
        min_len = min(len(sig1), len(sig2))
        s1 = sig1[:min_len]
        s2 = sig2[:min_len]
        norm1 = np.linalg.norm(s1)
        norm2 = np.linalg.norm(s2)
        if norm1 > 0 and norm2 > 0:
            coeff = float(np.dot(s1, s2) / (norm1 * norm2))
        else:
            coeff = 0.0
        return coeff

    # Also compute chroma profile cosine similarity
    def chroma_similarity(fn1, fn2):
        v1 = np.array(list(results[fn1]["harmonic"]["chroma_profile"].values()))
        v2 = np.array(list(results[fn2]["harmonic"]["chroma_profile"].values()))
        n1 = np.linalg.norm(v1)
        n2 = np.linalg.norm(v2)
        return float(np.dot(v1, v2) / (n1 * n2)) if n1 > 0 and n2 > 0 else 0.0

    pair_base_int = compute_similarity(base_mono, int_mono)
    pair_base_dan = compute_similarity(base_mono, dan_mono)
    pair_int_dan = compute_similarity(int_mono, dan_mono)

    chroma_base_int = chroma_similarity("music_gameplay_base.wav", "music_gameplay_intensity.wav")
    chroma_base_dan = chroma_similarity("music_gameplay_base.wav", "music_gameplay_danger.wav")
    chroma_int_dan = chroma_similarity("music_gameplay_intensity.wav", "music_gameplay_danger.wav")

    inter_analysis = {
        "signal_cross_correlation": {
            "base_vs_intensity": round(pair_base_int, 4),
            "base_vs_danger": round(pair_base_dan, 4),
            "intensity_vs_danger": round(pair_int_dan, 4)
        },
        "harmonic_chroma_similarity": {
            "base_vs_intensity": round(chroma_base_int, 4),
            "base_vs_danger": round(chroma_base_dan, 4),
            "intensity_vs_danger": round(chroma_int_dan, 4)
        }
    }

    txt_lines.append(f"Waveform Cross-Correlation:")
    txt_lines.append(f"  Base vs Intensity:     {pair_base_int:.4f}")
    txt_lines.append(f"  Base vs Danger:        {pair_base_dan:.4f}")
    txt_lines.append(f"  Intensity vs Danger:   {pair_int_dan:.4f}")
    txt_lines.append(f"Harmonic Chroma Similarity:")
    txt_lines.append(f"  Base vs Intensity:     {chroma_base_int:.4f}")
    txt_lines.append(f"  Base vs Danger:        {chroma_base_dan:.4f}")
    txt_lines.append(f"  Intensity vs Danger:   {chroma_int_dan:.4f}")

    # Final verdict
    # Perfect musical stems bounced from a DAW have high envelope correlation (downbeat lock)
    # and harmonious chroma.
    # Independent AI generations have very low correlation and differing tempo/meter drift.
    bpms = [results[fn]["estimated_bpm"] for fn in filenames]
    bpm_diff = max(bpms) - min(bpms)
    
    txt_lines.append("\n" + "=" * 70)
    txt_lines.append("SYNCHRONIZATION VERDICT & TECHNICAL QA ASSESSMENT")
    txt_lines.append("=" * 70)
    
    is_synchronized = (bpm_diff < 0.5 and abs(pair_base_int) > 0.4 and chroma_base_int > 0.85)
    
    if is_synchronized:
        verdict = "APPROVED"
        verdict_desc = "The three tracks exhibit synchronized downbeats, matching BPM, and harmonious chord structures."
    else:
        verdict = "REQUIRES MANUAL MUSIC PRODUCTION"
        verdict_desc = (
            "CRITICAL MUSICAL MISMATCH DETECTED: The three files were synthesized as independent musical compositions "
            "rather than stems exported from a single DAW master session. They exhibit divergent beat onsets, differing "
            "internal tempos, and independent harmonic progressions. Merely looping or time-stretching them will cause "
            "severe cacophony and audible dissonance when played concurrently."
        )

    txt_lines.append(f"VERDICT: {verdict}")
    txt_lines.append(f"ANALYSIS DETAIL:\n{verdict_desc}")
    txt_lines.append("=" * 70)

    final_report = {
        "analysis_timestamp": "2026-09-13T14:15:00",
        "target_spec": {
            "bpm": 138,
            "key": "D Minor",
            "meter": "4/4",
            "bars": 16,
            "target_duration_seconds": 27.8260869565,
            "target_samples_48khz": 1335652
        },
        "stem_results": results,
        "inter_stem_analysis": inter_analysis,
        "verdict": verdict,
        "verdict_description": verdict_desc
    }

    # Write JSON and TXT
    json_path = os.path.join(base_dir, "music_stem_analysis.json")
    txt_path = os.path.join(base_dir, "music_stem_analysis.txt")

    with open(json_path, "w", encoding="utf-8") as f:
        json.dump(final_report, f, indent=2)

    with open(txt_path, "w", encoding="utf-8") as f:
        f.write("\n".join(txt_lines))

    print(f"Analysis complete.")
    print(f"JSON report: {json_path}")
    print(f"TXT report:  {txt_path}")
    print(f"Verdict:     {verdict}")
    
    return 0

if __name__ == "__main__":
    sys.exit(analyze_all_stems())

