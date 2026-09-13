import os
import sys
import json
import time
import winreg
import wave
import struct
import requests
import numpy as np

# Import validator
try:
    from tools.validate_audio import validate_wav_file
except ModuleNotFoundError:
    from validate_audio import validate_wav_file

def get_api_key():
    key = os.environ.get("ELEVENLABS_API_KEY")
    if not key:
        try:
            reg_key = winreg.OpenKey(winreg.HKEY_CURRENT_USER, r"Environment")
            key, _ = winreg.QueryValueEx(reg_key, "ELEVENLABS_API_KEY")
        except Exception:
            pass
    return key

def pcm_to_wav24(pcm_data, in_rate=44100, out_rate=48000, out_channels=1):
    """
    Converts raw 16-bit mono PCM from ElevenLabs to 48,000 Hz, 24-bit PCM WAV (Mono or Stereo).
    Includes DC offset removal and peak normalization to -0.5 dBFS.
    """
    audio_int16 = np.frombuffer(pcm_data, dtype=np.int16)
    audio_float = audio_int16.astype(np.float32) / 32768.0
    
    num_in_samples = len(audio_float)
    num_out_samples = int(round(num_in_samples * (out_rate / in_rate)))
    
    # 1. Resample to 48,000 Hz
    if in_rate != out_rate:
        x_in = np.linspace(0, 1, num_in_samples, endpoint=False)
        x_out = np.linspace(0, 1, num_out_samples, endpoint=False)
        mono_resampled = np.interp(x_out, x_in, audio_float)
    else:
        mono_resampled = audio_float
        
    # 2. DC offset removal
    mono_resampled = mono_resampled - np.mean(mono_resampled)
    
    # 3. Peak normalization to -0.5 dBFS (~0.9441)
    max_val = np.max(np.abs(mono_resampled))
    if max_val > 0.001:
        mono_resampled = (mono_resampled / max_val) * 0.9441
        
    # 4. Channel routing (mono or stereo)
    if out_channels == 2:
        final_samples = np.empty(num_out_samples * 2, dtype=np.float32)
        final_samples[0::2] = mono_resampled
        final_samples[1::2] = mono_resampled
    else:
        final_samples = mono_resampled
        
    # 5. Scale to 24-bit integer
    audio_24bit_int = np.clip(final_samples * 8388607.0, -8388608, 8388607).astype(np.int32)
    
    # 6. Pack 24-bit bytes (3 bytes per sample, little-endian)
    raw_24 = bytearray()
    for s in audio_24bit_int:
        b = int(s).to_bytes(4, byteorder='little', signed=True)
        raw_24.extend(b[:3])
        
    # 7. Create standard WAV container
    header = bytearray(b"RIFF")
    total_data_len = len(raw_24)
    file_size = 36 + total_data_len
    header.extend(file_size.to_bytes(4, byteorder="little"))
    header.extend(b"WAVEfmt ")
    header.extend((16).to_bytes(4, byteorder="little")) # Subchunk1Size
    header.extend((1).to_bytes(2, byteorder="little"))  # AudioFormat (1=PCM)
    header.extend(out_channels.to_bytes(2, byteorder="little")) # NumChannels
    header.extend(out_rate.to_bytes(4, byteorder="little")) # SampleRate
    byte_rate = out_rate * out_channels * 3
    header.extend(byte_rate.to_bytes(4, byteorder="little")) # ByteRate
    block_align = out_channels * 3
    header.extend(block_align.to_bytes(2, byteorder="little")) # BlockAlign
    header.extend((24).to_bytes(2, byteorder="little")) # BitsPerSample
    header.extend(b"data")
    header.extend(total_data_len.to_bytes(4, byteorder="little"))
    
    return bytes(header) + bytes(raw_24)

def update_status(status_path, total, gen, val, failed, missing, status_text="GENERATING", current_batch=None, current_file=None):
    status_data = {
        "required": total,
        "generated": gen,
        "validated": val,
        "failed": failed,
        "missing": missing,
        "status": status_text,
        "current_batch": current_batch,
        "last_processed": current_file,
        "timestamp": time.strftime("%Y-%m-%dT%H:%M:%S")
    }
    with open(status_path, "w", encoding="utf-8") as f:
        json.dump(status_data, f, indent=2)

def generate_asset(item, base_dir, headers, url):
    filename = item["filename"]
    cat = item["category"].lower()
    duration = item.get("duration", 1.0)
    channels_str = item.get("channels", "Mono")
    channels = 2 if channels_str.lower() == "stereo" else 1
    prompt = item["prompt"]

    target_dir = os.path.join(base_dir, "assets", "audio", cat)
    os.makedirs(target_dir, exist_ok=True)
    target_path = os.path.join(target_dir, filename)

    # Check if already generated and valid
    if os.path.exists(target_path):
        is_valid, _ = validate_wav_file(target_path)
        if is_valid:
            return True, "ALREADY_EXISTS"

    dur_clamped = min(max(float(duration), 0.5), 22.0)
    prompt_text = prompt[:450].rsplit(' ', 1)[0] if len(prompt) > 450 else prompt

    payload = {
        "text": prompt_text,
        "duration_seconds": dur_clamped,
        "prompt_influence": 0.3
    }
    request_url = f"{url}?output_format=pcm_44100"

    max_retries = 4
    for attempt in range(max_retries):
        try:
            res = requests.post(request_url, headers=headers, json=payload, timeout=60)
            if res.status_code == 200:
                raw_pcm = res.content
                wav_bytes = pcm_to_wav24(raw_pcm, in_rate=44100, out_rate=48000, out_channels=channels)
                with open(target_path, "wb") as wf:
                    wf.write(wav_bytes)
                    
                is_valid, val_details = validate_wav_file(target_path)
                if is_valid:
                    return True, "SUCCESS"
                else:
                    return False, f"VALIDATION_FAILED: {val_details.get('errors')}"
            elif res.status_code == 401:
                return False, f"AUTH_ERROR_401: {res.text[:200]}"
            elif res.status_code == 429:
                wait_sec = (attempt + 1) * 10
                print(f"      [429 Rate Limit] Backing off {wait_sec}s...")
                time.sleep(wait_sec)
            else:
                print(f"      [HTTP {res.status_code}] Attempt {attempt+1}/{max_retries}: {res.text[:150]}")
                time.sleep(4)
        except Exception as e:
            print(f"      [Exception] Attempt {attempt+1}/{max_retries}: {e}")
            time.sleep(4)

    return False, f"EXCEEDED_MAX_RETRIES_{max_retries}"

def generate_validation_reports(base_dir, manifest_assets):
    report_json_path = os.path.join(base_dir, "audio_validation_report.json")
    report_txt_path = os.path.join(base_dir, "audio_validation_report.txt")
    
    valid_count = 0
    invalid_count = 0
    missing_count = 0
    details_list = []
    
    txt_lines = []
    txt_lines.append("=" * 60)
    txt_lines.append("CYBER NINJA RUNNER - AUDIO VALIDATION REPORT")
    txt_lines.append("=" * 60)
    txt_lines.append(f"Generated on: {time.strftime('%Y-%m-%d %H:%M:%S')}")
    txt_lines.append(f"Total Required Assets: {len(manifest_assets)}")
    txt_lines.append("-" * 60)
    
    for item in manifest_assets:
        filename = item["filename"]
        cat = item["category"].lower()
        target_path = os.path.join(base_dir, "assets", "audio", cat, filename)
        
        if not os.path.exists(target_path):
            missing_count += 1
            entry = {"filename": filename, "category": cat, "status": "MISSING", "details": None}
            details_list.append(entry)
            txt_lines.append(f"[MISSING] {cat}/{filename}")
        else:
            is_valid, details = validate_wav_file(target_path)
            if is_valid:
                valid_count += 1
                entry = {"filename": filename, "category": cat, "status": "VALID", "details": details}
                details_list.append(entry)
                txt_lines.append(f"[VALID]   {cat}/{filename} | {details['duration_seconds']}s | 48kHz | 24b | {details['channels']}ch")
            else:
                invalid_count += 1
                entry = {"filename": filename, "category": cat, "status": "INVALID", "details": details}
                details_list.append(entry)
                txt_lines.append(f"[INVALID] {cat}/{filename} | Errors: {details.get('errors')}")
                
    txt_lines.append("=" * 60)
    txt_lines.append(f"SUMMARY: Valid: {valid_count} | Invalid: {invalid_count} | Missing: {missing_count} | Total: {len(manifest_assets)}")
    txt_lines.append("=" * 60)
    
    report_data = {
        "timestamp": time.strftime("%Y-%m-%dT%H:%M:%S"),
        "total_required": len(manifest_assets),
        "valid": valid_count,
        "invalid": invalid_count,
        "missing": missing_count,
        "assets": details_list
    }
    
    with open(report_json_path, "w", encoding="utf-8") as f:
        json.dump(report_data, f, indent=2)
        
    with open(report_txt_path, "w", encoding="utf-8") as f:
        f.write("\n".join(txt_lines))
        
    return valid_count, invalid_count, missing_count

def run_production_pipeline():
    api_key = get_api_key()
    if not api_key:
        print("FATAL: ELEVENLABS_API_KEY is not configured.")
        return 1

    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    manifest_path = os.path.join(base_dir, "audio_generation_manifest.json")
    status_path = os.path.join(base_dir, "audio_generation_status.json")

    with open(manifest_path, "r", encoding="utf-8") as f:
        manifest = json.load(f)

    all_assets = manifest.get("assets", [])
    total_required = len(all_assets)
    print(f"Loaded manifest with {total_required} required production assets.")

    # 7 Batches strictly ordered:
    # Batch 1 — Music
    # Batch 2 — Player
    # Batch 3 — Combat
    # Batch 4 — Enemies
    # Batch 5 — Gameplay
    # Batch 6 — UI
    # Batch 7 — Environment
    batch_categories = [
        ("Batch 1 - Music", "Music"),
        ("Batch 2 - Player", "Player"),
        ("Batch 3 - Combat", "Combat"),
        ("Batch 4 - Enemies", "Enemies"),
        ("Batch 5 - Gameplay", "Gameplay"),
        ("Batch 6 - UI", "UI"),
        ("Batch 7 - Environment", "Environment"),
    ]

    batches = []
    for b_name, cat in batch_categories:
        b_items = [a for a in all_assets if a["category"].lower() == cat.lower()]
        batches.append((b_name, b_items))

    url = "https://api.elevenlabs.io/v1/sound-generation"
    headers = {
        "xi-api-key": api_key,
        "Content-Type": "application/json"
    }

    # Initial scan of existing files
    initial_valid = 0
    for a in all_assets:
        target_path = os.path.join(base_dir, "assets", "audio", a["category"].lower(), a["filename"])
        if os.path.exists(target_path):
            is_valid, _ = validate_wav_file(target_path)
            if is_valid:
                initial_valid += 1

    print(f"Pre-scan: {initial_valid}/{total_required} already exist and passed validation.")
    update_status(status_path, total_required, initial_valid, initial_valid, 0, total_required - initial_valid, status_text="GENERATING")

    global_index = 0
    failed_items = []

    for b_name, items in batches:
        print(f"\n>>> Starting {b_name} ({len(items)} assets) <<<")
        for item in items:
            global_index += 1
            filename = item["filename"]
            cat = item["category"].lower()
            target_path = os.path.join(base_dir, "assets", "audio", cat, filename)

            # Check if valid already
            if os.path.exists(target_path):
                is_valid, _ = validate_wav_file(target_path)
                if is_valid:
                    print(f"[{global_index}/{total_required}] [SKIP] {cat}/{filename} is already valid.")
                    continue

            print(f"[{global_index}/{total_required}] [GENERATING] {cat}/{filename} (Target: {item.get('duration')}s, {item.get('channels')})...")
            success, reason = generate_asset(item, base_dir, headers, url)

            if success:
                print(f"    -> [SUCCESS] {filename}")
            else:
                print(f"    -> [FAILED] {filename}: {reason}")
                failed_items.append(item)

            # Count current state
            current_valid, current_invalid, current_missing = generate_validation_reports(base_dir, all_assets)
            update_status(status_path, total_required, current_valid + current_invalid, current_valid, len(failed_items), current_missing,
                          status_text="GENERATING", current_batch=b_name, current_file=filename)

            # Rate limit politeness
            time.sleep(1.0)

    # Retry pass for any failed items
    if failed_items:
        print(f"\n==========================================")
        print(f"RETRY PASS FOR {len(failed_items)} FAILED ASSETS")
        print(f"==========================================")
        retry_list = list(failed_items)
        failed_items = []
        for idx, item in enumerate(retry_list, 1):
            filename = item["filename"]
            cat = item["category"].lower()
            print(f"[RETRY {idx}/{len(retry_list)}] {cat}/{filename}...")
            time.sleep(3.0)
            success, reason = generate_asset(item, base_dir, headers, url)
            if success:
                print(f"    -> [RETRY SUCCESS] {filename}")
            else:
                print(f"    -> [RETRY FAILED] {filename}: {reason}")
                failed_items.append(item)
            current_valid, current_invalid, current_missing = generate_validation_reports(base_dir, all_assets)
            update_status(status_path, total_required, current_valid + current_invalid, current_valid, len(failed_items), current_missing,
                          status_text="GENERATING", current_batch="Retry Pass", current_file=filename)

    # Final reports
    final_valid, final_invalid, final_missing = generate_validation_reports(base_dir, all_assets)
    is_completed = (final_valid == total_required and final_invalid == 0 and final_missing == 0)
    status_str = "COMPLETED" if is_completed else "INCOMPLETE"

    update_status(status_path, total_required, final_valid + final_invalid, final_valid, len(failed_items), final_missing,
                  status_text=status_str, current_batch="Done", current_file=None)

    print(f"\n==========================================")
    print(f"PIPELINE GENERATION FINISHED")
    print(f"Required: {total_required}")
    print(f"Validated: {final_valid}")
    print(f"Invalid: {final_invalid}")
    print(f"Missing: {final_missing}")
    print(f"Failed: {len(failed_items)}")
    print(f"Status: {status_str}")
    print(f"==========================================")

    return 0 if is_completed else 1

if __name__ == "__main__":
    sys.exit(run_production_pipeline())
