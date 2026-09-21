function inspect(path) {
    var ev = studio.project.lookup(path);
    console.log("=== Inspecting " + path + " ===");
    console.log("Name: " + ev.name);
    console.log("Banks count: " + ev.banks.length);
    for (var i = 0; i < ev.banks.length; i++) {
        console.log("  Bank: " + ev.banks[i].name);
    }
    console.log("Group tracks count: " + ev.groupTracks.length);
    for (var i = 0; i < ev.groupTracks.length; i++) {
        var gt = ev.groupTracks[i];
        console.log("  Track " + i + ": " + (gt.mixerGroup ? gt.mixerGroup.name : "unnamed"));
        console.log("    Modules count: " + gt.modules.length);
        for (var j = 0; j < gt.modules.length; j++) {
            var m = gt.modules[j];
            console.log("      Module " + j + " (" + m.entity + "): length=" + m.length + ", start=" + m.start + ", audioFile=" + (m.audioFile ? m.audioFile.assetPath : "none") + ", isStreaming=" + (m.audioFile ? m.audioFile.isStreaming : "n/a"));
            if (m.looping !== undefined) {
                console.log("        looping: " + m.looping);
            }
        }
    }
    console.log("Timeline markers count: " + (ev.timeline ? ev.timeline.markers.length : 0));
    if (ev.timeline) {
        for (var k = 0; k < ev.timeline.markers.length; k++) {
            var mk = ev.timeline.markers[k];
            console.log("  Marker " + k + " (" + mk.entity + "): name=" + mk.name + ", pos=" + mk.position + ", len=" + mk.length);
        }
    }
    console.log("MasterBus output: " + (ev.mixer && ev.mixer.masterBus && ev.mixer.masterBus.output ? ev.mixer.masterBus.output.name : "none"));
    console.log("MixerInput output: " + (ev.mixerInput && ev.mixerInput.output ? ev.mixerInput.output.name : "none"));
}

inspect("event:/Music/Gameplay");
inspect("event:/Music/Menu");

