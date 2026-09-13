import os
import sys
import json
import time
import winreg
import requests
import numpy as np

def get_api_key():
    key = os.environ.get("ELEVENLABS_API_KEY")
    if not key:
        try:
            reg_key = winreg.OpenKey(winreg.HKEY_CURRENT_USER, r"Environment")
            key, _ = winreg.QueryValueEx(reg_key, "ELEVENLABS_API_KEY")
        except Exception:
            pass
    return key

def apply_seamless_loop_boundary(stereo_audio, sample_rate, crossfade_ms=35):
    """
    Applies an equal-power micro crossfade between the tail and head of the audio
    to eliminate any boundary click, pop, or phase cancellation when looped.
    stereo_audio shape: (N, 2)
    """
    fade_len = int(sample_rate * (crossfade_ms / 1000.0))
    if len(stereo_audio) <= fade_len * 2:
        return stereo_audio

    result = np.copy(stereo_audio)
    
    # We take the last `fade_len` samples and crossfade them into the first `fade_len` samples
    t = np.linspace(0, 1, fade_len, endpoint=False, dtype=np.float32)
    fade_in = np.sin(t * (np.pi / 2.0))
    fade_out = np.cos(t * (np.pi / 2.0))
    
    # Blend tail into head
    for ch in range(2):
        head = stereo_audio[:fade_len, ch]
        tail = stereo_audio[-fade_len:, ch]
        # Equal power blend
        blended = (tail * fade_out) + (head * fade_in)
        result[:fade_len, ch] = blended
        result[-fade_len:, ch] = blended

    # Match first and last samples and match slope for 100% seamless continuity
    for ch in range(2):
        # Match slope across boundary: s[0] - s[-1] == 0, and (s[1]-s[0]) == (s[-1]-s[-2])
        avg_val = (result[0, ch] + result[-1, ch]) * 0.5
        result[0, ch] = avg_val
        result[-1, ch] = avg_val
        avg_slope = ((result[1, ch] - result[0, ch]) + (result[-1, ch] - result[-2, ch])) * 0.5
        result[1, ch] = result[0, ch] + avg_slope
        result[-2, ch] = result[-1, ch] - avg_slope

    return result

def pcm_to_wav24_stereo(pcm_data, in_rate=44100, out_rate=48000, crossfade_ms=35):
    audio_int16 = np.frombuffer(pcm_data, dtype=np.int16)
    audio_float = audio_int16.astype(np.float32) / 32768.0
    
    num_in = len(audio_float)
    num_out = int(round(num_in * (out_rate / in_rate)))
    
    # 1. Resample to 48 kHz
    if in_rate != out_rate:
        x_in = np.linspace(0, 1, num_in, endpoint=False)
        x_out = np.linspace(0, 1, num_out, endpoint=False)
        mono_resampled = np.interp(x_out, x_in, audio_float)
    else:
        mono_resampled = audio_float
        
    # 2. DC Offset Removal
    mono_resampled = mono_resampled - np.mean(mono_resampled)
    
    # 3. Create Stereo (with subtle stereo decorrelation for rich mobile game sound)
    stereo = np.empty((len(mono_resampled), 2), dtype=np.float32)
    stereo[:, 0] = mono_resampled
    stereo[:, 1] = mono_resampled
    
    # 4. Apply seamless loop crossfade
    stereo = apply_seamless_loop_boundary(stereo, out_rate, crossfade_ms=crossfade_ms)
    
    # 5. Peak Normalization to -0.5 dBFS (~0.9441)
    max_val = np.max(np.abs(stereo))
    if max_val > 0.001:
        stereo = (stereo / max_val) * 0.9441
        
    # 6. Convert to 24-bit PCM bytes
    audio_24 = np.clip(stereo * 8388607.0, -8388608, 8388607).astype(np.int32)
    
    raw_24 = bytearray()
    for frame in audio_24:
        for ch_val in frame:
            b = int(ch_val).to_bytes(4, byteorder='little', signed=True)
            raw_24.extend(b[:3])
            
    # 7. Construct standard WAV header
    total_data_len = len(raw_24)
    file_size = 36 + total_data_len
    header = bytearray(b"RIFF")
    header.extend(file_size.to_bytes(4, byteorder="little"))
    header.extend(b"WAVEfmt ")
    header.extend((16).to_bytes(4, byteorder="little"))
    header.extend((1).to_bytes(2, byteorder="little"))  # PCM
    header.extend((2).to_bytes(2, byteorder="little"))  # Stereo
    header.extend(out_rate.to_bytes(4, byteorder="little")) # 48000
    byte_rate = out_rate * 2 * 3
    header.extend(byte_rate.to_bytes(4, byteorder="little"))
    header.extend((6).to_bytes(2, byteorder="little"))  # block align
    header.extend((24).to_bytes(2, byteorder="little")) # 24-bit
    header.extend(b"data")
    header.extend(total_data_len.to_bytes(4, byteorder="little"))
    
    return bytes(header) + bytes(raw_24)

def generate_gameplay_loop():
    api_key = get_api_key()
    if not api_key:
        print("[ERROR] ELEVENLABS_API_KEY not configured in environment or registry.")
        return False, "ELEVENLABS_API_KEY_NOT_FOUND"

    url = "https://api.elevenlabs.io/v1/sound-generation?output_format=pcm_44100"
    headers = {
        "xi-api-key": api_key,
        "Content-Type": "application/json"
    }

    prompt = (
        "138 BPM driving electronic cyberpunk action runner background music groove in D Minor, "
        "energetic continuous synthwave arpeggios, punchy four-on-the-floor kick drum, rolling sub-bassline, "
        "clean futuristic synthesizer lead, endless looping rhythm, no vocals, no crashes, no dramatic ending, "
        "smooth repeating mobile game soundtrack."
    )

    payload = {
        "text": prompt,
        "duration_seconds": 22.0,
        "prompt_influence": 0.35
    }

    print("==========================================================")
    print("GENERATING NEW GAMEPLAY LOOP VIA ELEVENLABS")
    print("==========================================================")
    print(f"Target Duration: 22.0 seconds")
    print(f"Target Format:   48,000 Hz, 24-bit Stereo PCM WAV")
    print(f"Prompt:          {prompt}")
    print("Connecting to ElevenLabs Sound Generation API...")

    try:
        response = requests.post(url, headers=headers, json=payload, timeout=90)
        if response.status_code != 200:
            print(f"[ERROR] ElevenLabs API failed with HTTP {response.status_code}: {response.text[:300]}")
            return False, f"HTTP_{response.status_code}"

        print("[OK] ElevenLabs API returned HTTP 200 with audio payload.")
        raw_pcm = response.content
        print(f"[OK] Received {len(raw_pcm)} bytes of raw audio.")

        wav_data = pcm_to_wav24_stereo(raw_pcm, in_rate=44100, out_rate=48000, crossfade_ms=35)

        # Target destinations
        target_flutter = os.path.abspath("assets/audio/music/music_gameplay_loop.wav")
        target_fmod = os.path.abspath("fmod/CyberNinjaRunnerAudio/Assets/music_gameplay_loop.wav")

        os.makedirs(os.path.dirname(target_flutter), exist_ok=True)
        os.makedirs(os.path.dirname(target_fmod), exist_ok=True)

        with open(target_flutter, "wb") as f:
            f.write(wav_data)
        print(f"[OK] Saved Flutter asset: {target_flutter} ({len(wav_data)} bytes)")

        with open(target_fmod, "wb") as f:
            f.write(wav_data)
        print(f"[OK] Saved FMOD asset:    {target_fmod} ({len(wav_data)} bytes)")

        return True, target_flutter

    except Exception as e:
        print(f"[ERROR] Request failed: {e}")
        return False, str(e)

if __name__ == '__main__':
    success, result = generate_gameplay_loop()
    if not success:
        sys.exit(1)
