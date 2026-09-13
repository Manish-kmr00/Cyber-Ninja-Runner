var ev = studio.project.lookup("event:/UI/Click");
console.log("Event: " + ev.name);
console.log("groupTracks length: " + ev.groupTracks.length);
if (ev.groupTracks.length > 0) {
    var track = ev.groupTracks[0];
    console.log("track name: " + track.name);
}
console.log("timeline: " + (ev.timeline ? ev.timeline.name : "none"));
console.log("banks: " + ev.banks.length);
for (var i = 0; i < ev.banks.length; i++) {
    console.log("  bank: " + ev.banks[i].name);
}

