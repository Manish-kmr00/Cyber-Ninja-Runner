import os
import sys
import time
import wave
import shutil
import tempfile
import subprocess
import numpy as np
import imageio_ffmpeg

ADB = os.path.expandvars(r"%LOCALAPPDATA%\Android\Sdk\platform-tools\adb.exe")
FFMPEG = imageio_ffmpeg.get_ffmpeg_exe()

STORE_VIDEO_DIR = os.path.abspath("store_video")
os.makedirs(STORE_VIDEO_DIR, exist_ok=True)

RAW_VIDEO_DEVICE = "/sdcard/cyber_ninja_runner_raw.mp4"
RAW_VIDEO_LOCAL = os.path.join(STORE_VIDEO_DIR, "cyber_ninja_runner_raw.mp4")
FINAL_SHOWCASE_LOCAL = os.path.join(STORE_VIDEO_DIR, "cyber_ninja_runner_gameplay_showcase.mp4")
MASTER_AUDIO_LOCAL = os.path.join(STORE_VIDEO_DIR, "master_audio.wav")

def run_adb(cmd_args):
    return subprocess.run([ADB] + cmd_args, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)

def adb_tap(x, y):
    run_adb(["shell", "input", "tap", str(x), str(y)])

def adb_key(keycode):
    run_adb(["shell", "input", "keyevent", str(keycode)])

def main():
    print("=== CYBER NINJA RUNNER MASTER GAMEPLAY SHOWCASE RECORDING ===")
    
    # 1. Ensure clean device environment
    run_adb(["shell", "rm", "-f", RAW_VIDEO_DEVICE])

    # 2. Launch Screenrecord process (Target: ~35 seconds)
    print("Starting screen recording (2144x960 @ 16Mbps, time-limit 35s)...")
    rec_proc = subprocess.Popen([
        ADB, "shell", "screenrecord",
        "--size", "2144x960",
        "--bit-rate", "16000000",
        "--time-limit", "35",
        RAW_VIDEO_DEVICE
    ])

    start_time = time.time()
    def elapsed():
        return time.time() - start_time

    def wait_to(target_sec):
        rem = target_sec - elapsed()
        if rem > 0:
            time.sleep(rem)

    print("0.0s - 2.5s: Capturing Start Menu...")
    wait_to(2.5)

    print("2.5s: Entering Endless Overdrive (Core Campaign)...")
    adb_tap(470, 690)

    # 3. Flawless Survival & Showcase Action Rhythm
    # Combines genuine in-game powerups (Kinetic Safe Ground Shield, Stealth Invisibility,
    # Matrix Slow-Mo) with high-octane parkour acrobatics (Jumps, Double Flips, Katana Slices).
    sfx_log = []
    
    # Wait for ninja spawn at ~3.4s
    wait_to(3.4)

    # Booster activations schedule: (timestamp, tap_x, tap_y, sfx_file, desc)
    booster_schedule = [
        (3.8, 110, 700, "assets/audio/gameplay/gameplay_shield_01.wav", "Activating Kinetic Safe-Ground Shield #1"),
        (11.2, 110, 700, "assets/audio/gameplay/gameplay_shield_02.wav", "Refreshing Kinetic Safe-Ground Shield #2"),
        (18.5, 110, 995, "assets/audio/gameplay/gameplay_powerup_01.wav", "Activating Stealth Invisibility Cloak"),
        (26.0, 110, 700, "assets/audio/gameplay/gameplay_shield_03.wav", "Activating Kinetic Safe-Ground Shield #3"),
        (32.2, 110, 845, "assets/audio/gameplay/gameplay_booster_01.wav", "Activating Matrix Slow-Mo Overdrive"),
    ]
    next_booster_idx = 0

    # 18 Cycles of dynamic parkour combat (covers 3.4s to 34.0s)
    total_cycles = 18
    for c in range(total_cycles):
        t_jump = 3.5 + c * 1.70
        wait_to(t_jump)

        # Check for scheduled booster activation
        if next_booster_idx < len(booster_schedule):
            b_t, bx, by, b_sfx, b_desc = booster_schedule[next_booster_idx]
            if elapsed() >= b_t:
                print(f"[{elapsed():.1f}s] >> {b_desc}")
                adb_tap(bx, by)
                sfx_log.append((elapsed(), b_sfx, 0.90))
                next_booster_idx += 1
        
        # Action: Jump
        adb_key(62)
        sfx_log.append((elapsed(), f"assets/audio/player/player_jump_0{1 + (c % 4)}.wav", 0.85))
        
        # Action: Aerial Double Jump
        time.sleep(0.32)
        adb_key(62)
        sfx_log.append((elapsed(), f"assets/audio/player/player_jump_0{1 + ((c + 1) % 4)}.wav", 0.85))

        # Mid-air CP collect / action
        if c % 2 == 1:
            sfx_log.append((elapsed() + 0.15, f"assets/audio/gameplay/gameplay_collect_0{1 + (c % 4)}.wav", 0.80))

        # Action: Katana Slash / Slide on landing
        time.sleep(0.38)
        adb_tap(2520, 1120)
        sfx_log.append((elapsed(), f"assets/audio/player/player_land_0{1 + (c % 3)}.wav", 0.70))
        sfx_log.append((elapsed() + 0.05, f"assets/audio/combat/combat_attack_0{1 + (c % 4)}.wav", 0.85))
        sfx_log.append((elapsed() + 0.08, f"assets/audio/combat/combat_hit_0{1 + (c % 3)}.wav", 0.85))
        if c % 3 == 0:
            sfx_log.append((elapsed() + 0.12, f"assets/audio/enemies/enemy_destroy_0{1 + (c % 3)}.wav", 0.80))

        print(f"[{elapsed():.1f}s] Cycle {c+1}/{total_cycles}: Jump -> Double Flip -> Katana Strike")

    # Final run sequence: ninja running at top speed into the cyber horizon
    wait_to(34.8)
    print("Ending recording while ninja is successfully running at top speed...")

    rec_proc.wait(timeout=10)
    total_rec_time = elapsed()
    print(f"Recording complete! Total duration: {total_rec_time:.2f}s")

    time.sleep(2.0)

    # 4. Pull raw video
    print(f"Pulling raw recording to {RAW_VIDEO_LOCAL}...")
    run_adb(["pull", RAW_VIDEO_DEVICE, RAW_VIDEO_LOCAL])
    if not os.path.exists(RAW_VIDEO_LOCAL) or os.path.getsize(RAW_VIDEO_LOCAL) < 100000:
        print("ERROR: Raw video recording failed or empty!")
        sys.exit(1)

    print(f"Raw video pulled successfully: {os.path.getsize(RAW_VIDEO_LOCAL):,} bytes")

    # 5. Synthesize Authentic Master Game Audio
    print("Generating Authentic Master Game Audio...")
    generate_master_audio(total_rec_time, sfx_log)

    # 6. Mux final video
    print("Muxing final showcase video with FFMPEG...")
    cmd = [
        FFMPEG, "-y",
        "-i", RAW_VIDEO_LOCAL,
        "-i", MASTER_AUDIO_LOCAL,
        "-c:v", "copy",
        "-c:a", "aac",
        "-b:a", "192k",
        "-shortest",
        FINAL_SHOWCASE_LOCAL
    ]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    if res.returncode != 0:
        print("FFMPEG MUX ERROR:", res.stderr)
        sys.exit(1)

    print("\n==================================================")
    print("SHOWCASE VIDEO CREATED SUCCESSFULLY!")
    print(f"FILE: {FINAL_SHOWCASE_LOCAL}")
    print(f"SIZE: {os.path.getsize(FINAL_SHOWCASE_LOCAL):,} bytes")
    print("==================================================")

def convert_to_pcm16(input_path, tmp_dir):
    """Converts any audio file (16-bit, 24-bit, mono, stereo) to standard 16-bit 48000Hz stereo PCM WAV."""
    base = os.path.splitext(os.path.basename(input_path))[0]
    out_path = os.path.join(tmp_dir, f"{base}_16k.wav")
    cmd = [
        FFMPEG, "-y",
        "-i", input_path,
        "-ar", "48000",
        "-ac", "2",
        "-c:a", "pcm_s16le",
        out_path
    ]
    subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, check=True)
    return out_path

def read_pcm16_wav(wav_path):
    with wave.open(wav_path, 'rb') as w:
        nframes = w.getnframes()
        raw = w.readframes(nframes)
        data = np.frombuffer(raw, dtype=np.int16).astype(np.float32) / 32768.0
        data = data.reshape(-1, 2)
        return data

def generate_master_audio(duration_sec, sfx_log):
    tmp_dir = tempfile.mkdtemp(prefix="cnr_audio_")
    try:
        sr = 48000
        total_samples = int(duration_sec * sr) + sr
        master = np.zeros((total_samples, 2), dtype=np.float32)

        def overlay(audio_path, start_sec, duration_clip=None, volume=1.0, fade_in=0.0, fade_out=0.0):
            if not os.path.exists(audio_path):
                print(f"Warning: file not found: {audio_path}")
                return
            pcm_path = convert_to_pcm16(audio_path, tmp_dir)
            data = read_pcm16_wav(pcm_path)

            start_idx = int(start_sec * sr)
            if start_idx >= total_samples:
                return
            
            if duration_clip is not None:
                max_clip_samples = int(duration_clip * sr)
                data = data[:max_clip_samples]

            length = len(data)
            end_idx = min(start_idx + length, total_samples)
            chunk_len = end_idx - start_idx
            to_add = data[:chunk_len].copy() * volume

            if fade_in > 0:
                flen = min(int(fade_in * sr), chunk_len)
                fade = np.linspace(0, 1, flen)[:, None]
                to_add[:flen] *= fade

            if fade_out > 0:
                flen = min(int(fade_out * sr), chunk_len)
                fade = np.linspace(1, 0, flen)[:, None]
                to_add[-flen:] *= fade

            master[start_idx:end_idx] += to_add

        # Music Tracks: Menu music transitions seamlessly to gameplay music
        overlay("assets/audio/music/music_menu_loop.wav", 0.0, duration_clip=3.2, volume=0.70, fade_out=0.6)
        overlay("assets/audio/music/music_gameplay_loop.wav", 2.8, volume=0.65, fade_in=0.6)

        # UI click when launching game
        overlay("assets/audio/ui/ui_click_01.wav", 2.5, volume=0.80)

        # Dynamic SFX matching the actual recorded actions
        for t, path, vol in sfx_log:
            overlay(path, t, volume=vol)

        # Soft limiter / Normalization
        peak = np.max(np.abs(master))
        if peak > 0.95:
            master = master * (0.95 / peak)

        int_data = (master * 32767.0).astype(np.int16)
        with wave.open(MASTER_AUDIO_LOCAL, 'wb') as out_w:
            out_w.setnchannels(2)
            out_w.setsampwidth(2)
            out_w.setframerate(sr)
            out_w.writeframes(int_data.tobytes())

        print(f"Master audio successfully saved to: {MASTER_AUDIO_LOCAL}")
    finally:
        shutil.rmtree(tmp_dir, ignore_errors=True)

if __name__ == "__main__":
    main()
