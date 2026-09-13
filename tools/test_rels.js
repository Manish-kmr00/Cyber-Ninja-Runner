var ev = studio.project.lookup("event:/Gameplay/Checkpoint");
var sound = studio.project.lookup("{0bf74d05-008a-426f-ac3a-a25022961f96}");
console.log("sound: " + sound);
if (sound) {
    console.log("sound relationships:");
    for (var r in sound.relationships) {
        console.log("  rel: " + r);
    }
}
console.log("timeline relationships:");
for (var tr in ev.timeline.relationships) {
    console.log("  rel: " + tr);
}

