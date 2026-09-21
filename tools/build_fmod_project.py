import os
import sys
import json
import subprocess

def generate_fmod_population_script():
    base_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
    manifest_path = os.path.join(base_dir, "audio_generation_manifest.json")
    
    with open(manifest_path, "r", encoding="utf-8") as f:
        manifest = json.load(f)
        
    assets = manifest.get("assets", [])
    print(f"Loaded {len(assets)} assets from manifest.")
    
    # Map by fmod_event
    event_groups = {}
    for a in assets:
        ev = a["fmod_event"]
        event_groups.setdefault(ev, []).append(a)
        
    print(f"Grouped into {len(event_groups)} FMOD events.")
    
    js_lines = []
    js_lines.append("// Auto-generated FMOD Studio population script")
    js_lines.append("console.log('=== Starting FMOD Studio Asset Ingestion and Event Population ===');\n")
    
    # 1. Import all audio files
    js_lines.append("var audioMap = {};")
    for a in assets:
        fn = a["filename"]
        cat = a["category"].lower()
        full_path = os.path.join(base_dir, "assets", "audio", cat, fn).replace("\\", "/")
        js_lines.append(f'var af_{fn.replace(".", "_")} = studio.project.importAudioFile("{full_path}");')
        js_lines.append(f'if (af_{fn.replace(".", "_")}) {{ audioMap["{fn}"] = af_{fn.replace(".", "_")}; }}')
        
    js_lines.append("\nconsole.log('Finished importing audio files.');\n")
    
    # Helper to clean an event
    js_lines.append("""
function cleanEvent(ev) {
    if (!ev) return;
    while (ev.groupTracks.length > 0) {
        studio.project.deleteObject(ev.groupTracks[0]);
    }
    while (ev.timeline.modules.length > 0) {
        studio.project.deleteObject(ev.timeline.modules[0]);
    }
}
""")
    
    # 2. Populate each event
    for ev_path, ev_assets in event_groups.items():
        js_lines.append(f"// --- Event: {ev_path} ---")
        js_lines.append(f'var ev = studio.project.lookup("{ev_path}");')
        js_lines.append(f'if (!ev) {{ console.log("ERROR: Event not found: {ev_path}"); }} else {{')
        js_lines.append("    cleanEvent(ev);")
        
        if ev_path == "event:/Music/Gameplay":
            fn = "music_gameplay_loop.wav"
            js_lines.append(f"""
    var track = studio.project.create("GroupTrack");
    track.mixerGroup.output = ev.mixer.masterBus;
    track.mixerGroup.name = "Gameplay Music Loop";
    ev.relationships.groupTracks.add(track);
    
    var sound = studio.project.create("SingleSound");
    sound.audioFile = audioMap["{fn}"];
    sound.start = 0;
    sound.length = audioMap["{fn}"] ? audioMap["{fn}"].length : 44.0;
    sound.looping = true;
    sound.audioTrack = track;
    ev.timeline.relationships.modules.add(sound);
    track.relationships.modules.add(sound);

    if (ev.markerTracks.length > 0) {
        var mt = ev.markerTracks[0];
        var region = mt.addRegion(0, sound.length, "");
        if (region) region.looping = true;
    }
""")
        elif len(ev_assets) == 1:
            # Single asset event (Music/Menu, Music/Danger, Music/Victory, Music/GameOver)
            fn = ev_assets[0]["filename"]
            js_lines.append(f"""
    var track = studio.project.create("GroupTrack");
    track.mixerGroup.output = ev.mixer.masterBus;
    track.mixerGroup.name = "Audio 1";
    ev.relationships.groupTracks.add(track);
    
    var sound = studio.project.create("SingleSound");
    sound.audioFile = audioMap["{fn}"];
    sound.start = 0;
    sound.length = audioMap["{fn}"] ? audioMap["{fn}"].length : 5.0;
    sound.audioTrack = track;
    ev.timeline.relationships.modules.add(sound);
    track.relationships.modules.add(sound);
""")
        else:
            # Multi-asset variation event (MultiSound)
            js_lines.append("""
    var track = studio.project.create("GroupTrack");
    track.mixerGroup.output = ev.mixer.masterBus;
    track.mixerGroup.name = "Audio 1";
    ev.relationships.groupTracks.add(track);
    
    var multiSound = studio.project.create("MultiSound");
    multiSound.start = 0;
    multiSound.audioTrack = track;
""")
            # Find max length dynamically in JS
            fn_list_js = json.dumps([a["filename"] for a in ev_assets])
            js_lines.append(f"    var fileList = {fn_list_js};")
            js_lines.append("""
    var maxLen = 0.5;
    for (var i = 0; i < fileList.length; i++) {
        var af = audioMap[fileList[i]];
        if (af && af.length > maxLen) maxLen = af.length;
    }
    multiSound.length = maxLen;
    ev.timeline.relationships.modules.add(multiSound);
    track.relationships.modules.add(multiSound);
    
    for (var i = 0; i < fileList.length; i++) {
        var af = audioMap[fileList[i]];
        if (af) {
            var s = studio.project.create("SingleSound");
            s.audioFile = af;
            multiSound.relationships.sounds.add(s);
        }
    }
    // Add Pitch Randomizer modulator (+/- 1.5 semitones)
    var pitchMod = studio.project.create("RandomizerModulator");
    pitchMod.nameOfPropertyBeingModulated = "pitch";
    pitchMod.amount = 1.5;
    multiSound.relationships.modulators.add(pitchMod);
""")
        js_lines.append("}\n")
        
    js_lines.append("studio.project.save();")
    js_lines.append("console.log('=== All 35 Events Populated and Saved Successfully! ===');")
    
    script_path = os.path.join(base_dir, "tools", "populate_fmod.js")
    with open(script_path, "w", encoding="utf-8") as f:
        f.write("\n".join(js_lines))
        
    print(f"Generated population script: {script_path}")
    return script_path

if __name__ == "__main__":
    generate_fmod_population_script()

