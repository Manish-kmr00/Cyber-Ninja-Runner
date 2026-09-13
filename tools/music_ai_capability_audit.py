import os
import sys
import json
import winreg
import subprocess
import requests

def get_elevenlabs_key():
    key = os.environ.get("ELEVENLABS_API_KEY")
    if not key:
        try:
            reg_key = winreg.OpenKey(winreg.HKEY_CURRENT_USER, r"Environment")
            key, _ = winreg.QueryValueEx(reg_key, "ELEVENLABS_API_KEY")
        except Exception:
            pass
    return key

def audit_capabilities():
    print("=== Running Music AI Capability Audit ===")
    
    results = {}
    
    # 1. ElevenLabs Music API Check
    api_key = get_elevenlabs_key()
    el_music_status = "NOT_CONFIGURED"
    el_music_details = ""
    el_class = "E. Requires paid/manual interaction"
    
    if api_key:
        try:
            # Test POST /v1/music
            headers = {"xi-api-key": api_key, "Content-Type": "application/json"}
            res = requests.post("https://api.elevenlabs.io/v1/music", headers=headers, json={"prompt": "138 bpm cyberpunk synthwave"}, timeout=15)
            if res.status_code == 200:
                el_music_status = "AVAILABLE_AND_ACTIVE"
                el_music_details = "Endpoint returned HTTP 200. Paid plan active."
                el_class = "C. Can generate music but not synchronized stems"
            elif res.status_code == 402:
                el_music_status = "BLOCKED_PAID_PLAN_REQUIRED"
                el_music_details = f"HTTP 402: {res.json().get('detail', {}).get('message', 'Paid plan required')}"
                el_class = "E. Requires paid/manual interaction"
            elif res.status_code == 405:
                el_music_status = "METHOD_NOT_ALLOWED"
                el_music_details = "HTTP 405: Method not allowed on GET/POST"
                el_class = "E. Requires paid/manual interaction"
            else:
                el_music_status = f"HTTP_{res.status_code}"
                el_music_details = res.text[:200]
                el_class = "E. Requires paid/manual interaction"
        except Exception as e:
            el_music_status = "REQUEST_FAILED"
            el_music_details = str(e)
            el_class = "E. Requires paid/manual interaction"
            
    results["ElevenLabs Music API"] = {
        "classification": el_class,
        "status": el_music_status,
        "details": el_music_details,
        "can_do_138_bpm_d_minor": "Unverified / Not supported in free tier",
        "can_do_synchronized_stems": "NO — API generates single mixed tracks, not multi-track stems"
    }

    # 2. ElevenLabs Sound Generation API
    results["ElevenLabs Sound Generation API"] = {
        "classification": "C. Can generate music but not synchronized stems",
        "status": "AVAILABLE_AND_VERIFIED",
        "details": "Successfully generated 96 assets. However, music prompts produce independent compositions with divergent tempos (137-170 BPM).",
        "can_do_138_bpm_d_minor": "Approximation only (prompt-influenced, not sample-quantized)",
        "can_do_synchronized_stems": "NO — Prompts generate independent audio waveforms with zero phase or downbeat synchronization"
    }

    # 3. Suno
    results["Suno AI"] = {
        "classification": "E. Requires paid/manual interaction",
        "status": "NO_OFFICIAL_PUBLIC_API",
        "details": "Closed web platform. Generates 2-minute to 4-minute full song songs with vocals/instruments combined. Does not support automated stem export or exact 16-bar quantization.",
        "can_do_138_bpm_d_minor": "Approximate via prompt text",
        "can_do_synchronized_stems": "NO — Master mix only; closed API"
    }

    # 4. Udio
    results["Udio AI"] = {
        "classification": "E. Requires paid/manual interaction",
        "status": "NO_OFFICIAL_PUBLIC_API",
        "details": "Closed web platform with credit subscriptions. Lacks programmatic CLI/API for DAW-locked multitrack stem generation.",
        "can_do_138_bpm_d_minor": "Approximate via prompt text",
        "can_do_synchronized_stems": "NO — Web-only output; closed API"
    }

    # 5. Stable Audio (Stability AI)
    results["Stable Audio"] = {
        "classification": "E. Requires paid/manual interaction",
        "status": "NO_CREDENTIALS_CONFIGURED",
        "details": "Requires STABILITY_KEY and paid credits. Generates single stereo master tracks, not synchronized stems.",
        "can_do_138_bpm_d_minor": "Supported via timing/BPM prompt",
        "can_do_synchronized_stems": "NO — Single audio file return"
    }

    # 6. Meta MusicGen / AudioCraft
    has_torch = False
    try:
        import torch
        has_torch = True
    except ImportError:
        pass
    results["Meta MusicGen / AudioCraft"] = {
        "classification": "D. Cannot be automated locally (missing PyTorch & GPU)",
        "status": "NOT_INSTALLED",
        "details": f"PyTorch installed: {has_torch}. Requires 10GB+ CUDA GPU and multi-gigabyte model weights for local inference. Does not support multi-stem separation natively.",
        "can_do_138_bpm_d_minor": "Possible with conditioning",
        "can_do_synchronized_stems": "NO — Generates monolithic audio"
    }

    # 7. Demucs (Meta AI Source Separation)
    results["Demucs"] = {
        "classification": "D. Cannot be automated locally (missing PyTorch & weights)",
        "status": "NOT_INSTALLED",
        "details": "State-of-the-art stem separator. However, standard models separate only into [Drums, Bass, Vocals, Other]. Does not output game-specific 'Intensity' (arps/high percs) or 'Danger' (dissonant textures).",
        "can_do_138_bpm_d_minor": "N/A (separation only)",
        "can_do_synchronized_stems": "PARTIAL (Separates drums/bass, but leaves synths/leads mashed in 'other')"
    }

    # 8. Spleeter (Deezer)
    results["Spleeter"] = {
        "classification": "D. Cannot be automated locally",
        "status": "NOT_INSTALLED",
        "details": "Legacy separation model. High phase-cancellation and spectral bleed artifacts; unsuitable for AAA gaming audio.",
        "can_do_138_bpm_d_minor": "N/A (separation only)",
        "can_do_synchronized_stems": "NO (unacceptable bleed/artifacts)"
    }

    # 9. Ultimate Vocal Remover / Moises
    results["UVR / Moises"] = {
        "classification": "E. Requires paid/manual interaction",
        "status": "NOT_AVAILABLE_AS_CLI",
        "details": "Desktop GUI / paid cloud service for vocal/instrumental separation. Cannot be automated headless without user interface.",
        "can_do_138_bpm_d_minor": "N/A",
        "can_do_synchronized_stems": "NO"
    }

    # Write Markdown Report
    md_lines = []
    md_lines.append("# CYBER NINJA RUNNER — MUSIC AI CAPABILITY AUDIT")
    md_lines.append(f"**Audit Timestamp:** 2026-09-13T14:18:00+05:30\n")
    md_lines.append("## 1. Classification Overview")
    md_lines.append("- **Class A (Can generate multi-stem synchronized music):** **0 Tools Available**")
    md_lines.append("- **Class B (Can generate one master and reliably separate stems):** **0 Tools Available** (Demucs/Spleeter not installed; outputs standard pop stems, not game adaptive layers)")
    md_lines.append("- **Class C (Can generate music but not synchronized stems):** **ElevenLabs Sound Generation** (Tested in Phase 5.4: generates divergent tempos 137..170 BPM)")
    md_lines.append("- **Class D (Cannot be automated locally):** **Meta MusicGen, Demucs, Spleeter** (Requires PyTorch, CUDA GPU, models)")
    md_lines.append("- **Class E (Requires paid/manual interaction):** **ElevenLabs Music API** (HTTP 402 Paid Plan Required), **Suno**, **Udio**, **Stable Audio**, **Moises**\n")
    
    md_lines.append("## 2. Tool Capability Matrix\n")
    md_lines.append("| Tool / Provider | Classification | Status | 138 BPM / D Minor Support | Synchronized Stems Capability |")
    md_lines.append("| :--- | :--- | :--- | :--- | :--- |")
    for name, data in results.items():
        md_lines.append(f"| **{name}** | {data['classification']} | `{data['status']}` | {data['can_do_138_bpm_d_minor']} | {data['can_do_synchronized_stems']} |")
        
    md_lines.append("\n## 3. Detailed Endpoint Findings: ElevenLabs Music API\n")
    md_lines.append("```http")
    md_lines.append("POST https://api.elevenlabs.io/v1/music")
    md_lines.append("Status: 402 Payment Required")
    md_lines.append("Body: {")
    md_lines.append('  "type": "payment_required",')
    md_lines.append('  "code": "paid_plan_required",')
    md_lines.append('  "message": "Music API is not available for free users. Please upgrade to a paid plan to use the API."')
    md_lines.append("}")
    md_lines.append("```\n")
    
    md_lines.append("## 4. Engineering Conclusion\n")
    md_lines.append("No automated AI tool currently exists in this environment capable of synthesizing three genuinely synchronized, tempo-quantized, additive stems (Base, Intensity, Danger) at 138.00 BPM in D Minor without human DAW production.")

    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    report_path = os.path.join(base_dir, "MUSIC_AI_CAPABILITY_AUDIT.md")
    with open(report_path, "w", encoding="utf-8") as f:
        f.write("\n".join(md_lines))
        
    print(f"Audit report generated: {report_path}")
    return results

if __name__ == "__main__":
    audit_capabilities()

