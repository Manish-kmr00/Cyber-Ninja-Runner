function inspectVolumes(path) {
    var ev = studio.project.lookup(path);
    console.log("=== Volumes for " + path + " ===");
    console.log("ev.volume: " + ev.volume);
    if (ev.mixer && ev.mixer.masterBus) {
        console.log("masterBus.volume: " + ev.mixer.masterBus.volume);
        if (ev.mixer.masterBus.effectChain) {
            for (var e = 0; e < ev.mixer.masterBus.effectChain.effects.length; e++) {
                var eff = ev.mixer.masterBus.effectChain.effects[e];
                console.log("  masterBus effect " + e + ": " + eff.entity + ", volume: " + eff.volume);
            }
        }
    }
    for (var i = 0; i < ev.groupTracks.length; i++) {
        var gt = ev.groupTracks[i];
        console.log("Track " + i + " (" + (gt.mixerGroup ? gt.mixerGroup.name : "") + ") volume: " + (gt.mixerGroup ? gt.mixerGroup.volume : "n/a"));
        if (gt.mixerGroup && gt.mixerGroup.effectChain) {
            for (var e = 0; e < gt.mixerGroup.effectChain.effects.length; e++) {
                var eff = gt.mixerGroup.effectChain.effects[e];
                console.log("  track effect " + e + ": " + eff.entity + ", volume: " + eff.volume);
            }
        }
        for (var j = 0; j < gt.modules.length; j++) {
            var m = gt.modules[j];
            console.log("  module " + j + " volume: " + m.volume);
        }
    }
    console.log("Automators count: " + (ev.automators ? ev.automators.length : 0));
    if (ev.timeline && ev.timeline.automators) {
        console.log("Timeline automators count: " + ev.timeline.automators.length);
    }
}

inspectVolumes("event:/Music/Gameplay");
inspectVolumes("event:/Music/Menu");

