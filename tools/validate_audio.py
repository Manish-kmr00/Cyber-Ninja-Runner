import os
import sys
import wave
import struct
import json

def validate_wav_file(file_path):
    """
    Validates that a file is a valid 48,000 Hz, 24-bit PCM WAV with non-zero content.
    Returns (is_valid, details_dict)
    """
    if not os.path.exists(file_path):
        return False, {"error": "File does not exist"}
        
    file_size = os.path.getsize(file_path)
    if file_size < 44:
        return False, {"error": "File size too small for WAV header"}
        
    try:
        with wave.open(file_path, "rb") as wf:
            channels = wf.getnchannels()
            sample_width = wf.getsampwidth() # bytes per sample
            framerate = wf.getframerate()
            n_frames = wf.getnframes()
            duration = n_frames / float(framerate) if framerate > 0 else 0
            
            bit_depth = sample_width * 8
            
            # Check mandatory criteria
            errors = []
            if framerate != 48000:
                errors.append(f"Sample rate is {framerate} Hz, expected 48000 Hz")
            if bit_depth != 24:
                errors.append(f"Bit depth is {bit_depth}-bit, expected 24-bit")
            if duration <= 0.01:
                errors.append(f"Duration is too short ({duration:.3f}s)")
                
            # Read first chunk of frames to check for silence
            frames_to_read = min(n_frames, 4800) # 100ms
            data = wf.readframes(frames_to_read)
            if not any(data):
                errors.append("File starts with complete zero/silence")
                
            details = {
                "file": file_path,
                "file_size": file_size,
                "channels": channels,
                "sample_rate": framerate,
                "bit_depth": bit_depth,
                "frames": n_frames,
                "duration_seconds": round(duration, 4),
                "valid": len(errors) == 0,
                "errors": errors
            }
            return len(errors) == 0, details
    except Exception as e:
        return False, {"error": f"Invalid WAV file format: {str(e)}"}

def validate_all():
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    manifest_path = os.path.join(base_dir, "audio_generation_manifest.json")
    status_path = os.path.join(base_dir, "audio_generation_status.json")
    
    if not os.path.exists(manifest_path):
        print(f"Error: Manifest not found at {manifest_path}")
        return 1
        
    with open(manifest_path, "r", encoding="utf-8") as f:
        manifest = json.load(f)
        
    assets = manifest.get("assets", [])
    total_required = len(assets)
    generated = 0
    validated = 0
    missing = 0
    
    results = []
    
    for item in assets:
        filename = item["filename"]
        cat = item["category"].lower()
        target_path = os.path.join(base_dir, "assets", "audio", cat, filename)
        
        if os.path.exists(target_path):
            generated += 1
            is_valid, details = validate_wav_file(target_path)
            if is_valid:
                validated += 1
                results.append({"filename": filename, "status": "VALID", "details": details})
            else:
                results.append({"filename": filename, "status": "INVALID", "details": details})
        else:
            missing += 1
            results.append({"filename": filename, "status": "MISSING"})
            
    print(f"Validation Summary:")
    print(f"Total Required: {total_required}")
    print(f"Physically Generated: {generated}")
    print(f"Passed 48kHz/24-bit Validation: {validated}")
    print(f"Missing: {missing}")
    
    # Update audio_generation_status.json
    status_data = {
        "project": "Cyber Ninja Runner",
        "status": "COMPLETED" if validated == total_required else "IN_PROGRESS" if generated > 0 else "BLOCKED",
        "total_required": total_required,
        "generated": generated,
        "validated": validated,
        "missing": missing
    }
    with open(status_path, "w", encoding="utf-8") as f:
        json.dump(status_data, f, indent=2)
        
    return 0 if validated == total_required else 1

if __name__ == "__main__":
    sys.exit(validate_all())

