# CYBER NINJA RUNNER — PHASE 5.5 FINAL DECISION
**Audit Date:** 2026-09-13T14:18:30+05:30  
**Project:** Cyber Ninja Runner (Flutter + Flame + FMOD Studio 2.03.14 + Android)

---

## FINAL DECISION

```
======================================================================
               AUTOMATED MUSIC PRODUCTION = NOT RELIABLE
======================================================================
```

---

## 1. Why Automated Production Cannot Deliver Synchronized Stems

1. **Fundamental Architectural Limitation of AI Audio Generation:**
   AI audio diffusion and transformer models (ElevenLabs, Suno, Udio, Stable Audio) synthesize audio as monolithic flattened stereo waveforms from noise latents. They do not maintain internal MIDI tracks or discrete multitrack DAW arrangements. When prompted separately for "Base", "Intensity", and "Danger" layers, the AI generates three separate musical tracks with different tempos (~170 BPM vs ~137 BPM vs ~144 BPM) and differing tonal keys (C vs B), resulting in zero cross-correlation (`0.0001`) and extreme polyrhythmic clash.

2. **Source Separation Does Not Produce Game Stems:**
   Even if source separation tools (Demucs/Spleeter) were deployed, they decompose music into conventional pop stems (`drums`, `bass`, `vocals`, `other`). They cannot deconstruct a single track into dynamic game-state layers like "Intensity" (high-energy synth arpeggios + rhythm enhancers) and "Danger" (dissonant tension leads + dark risers).

3. **API Access Restrictions:**
   - **ElevenLabs Music API (`POST /v1/music`):** Tested live and returned `HTTP 402 Payment Required` (`"Music API is not available for free users. Please upgrade to a paid plan to use the API."`).
   - **Suno / Udio:** Closed proprietary web services with no public automated REST API or stem-export pipeline.
   - **Stable Audio:** Lacks multitrack stem generation endpoints.

---

## 2. Methods Tested

| Candidate Solution | Method / Provider | Test Outcome | Blocker |
| :--- | :--- | :---: | :--- |
| **Option A (Master + Separation)** | Master synthwave + Demucs/Spleeter | **FAILED** | No local PyTorch/Demucs; standard stems (drums/bass/other) do not map to adaptive gameplay Intensity/Danger. |
| **Option B (Native Multi-Stem AI)** | Direct AI Stem API | **FAILED** | No public AI tool offers native synchronized multitrack stem synthesis. |
| **Option C (ElevenLabs Music API)** | `POST /v1/music` | **BLOCKED** | HTTP 402: Paid plan required on user account. |
| **Option C2 (ElevenLabs Sound Gen)** | `POST /v1/sound-generation` | **TESTED** | Generates independent, non-synchronized audio files (tempo drift 137..170 BPM). |
| **Option D (Spectral / EQ Slicing)** | Single track split by frequency | **REJECTED** | Faking stems by frequency splitting produces hollow, phase-smeared, and musically unconvincing audio. |

---

## 3. Required Deliverables for Human Composer / DAW Producer

To ensure the adaptive music in `event:/Music/Gameplay` sounds AAA quality and functions seamlessly with the already-implemented FMOD parameters (`MusicState`, `DangerIntensity`, `PlayerSpeed`), a composer or sound designer using a DAW (Ableton Live, FL Studio, Logic Pro, or Reaper) must provide:

### Deliverable Specifications:
- **Tempo:** Exactly **138.00 BPM** (constant, no drift)
- **Key Center:** **D Minor**
- **Time Signature:** **4/4**
- **Cycle Length:** Exactly **16 bars**
- **Mathematical Sample Count:** **1,335,652 samples** at 48,000 Hz
- **Exact Duration:** **27.826087 seconds**
- **Audio Format:** **WAV, 48,000 Hz, 24-bit PCM, Stereo**
- **Normalization:** -0.5 dBFS True Peak, zero DC offset
- **Loop Points:** Zero-crossing at start sample `0` and end sample `1,335,652` for seamless looping without clicks

### Required Files:
1. **`music_gameplay_base.wav` (Base Layer):**
   - Kick, sub-bass, main snare/clap, fundamental rhythm synth bed.
2. **`music_gameplay_intensity.wav` (Intensity Layer):**
   - High-energy 16th-note synth arpeggios, hi-hats, percussion layers, rhythmic glitch elements (NO duplicate sub-bass or conflicting chords).
3. **`music_gameplay_danger.wav` (Danger Layer):**
   - Aggressive distorted synth leads, dark pads, tension risers, siren pulses in D Minor (designed to sit on top of Base without harmonic clash).

### Ingestion Procedure:
When these 3 files are exported from the DAW, simply drop them into:
```
assets/audio/music/
```
and execute:
```bash
python tools/build_fmod_project.py
```
The FMOD project, all 6 banks, and the Flutter runtime will update instantly with zero code refactoring needed.

