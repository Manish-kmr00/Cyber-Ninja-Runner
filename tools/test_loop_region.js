var ev = studio.project.lookup("event:/Music/Gameplay");
console.log("Gameplay event:", ev.name);
if (ev.markerTracks.length > 0) {
    var mt = ev.markerTracks[0];
    console.log("Marker track:", mt);
    var region = mt.addRegion(0, 44.0, "Loop");
    console.log("Region added:", region);
    if (region) {
        console.log("Region entity:", region.entity);
        region.looping = true;
    }
}

