var ev = studio.project.lookup("event:/Gameplay/Checkpoint");
console.log("Event: " + ev.name);
console.log("ev.timeline: " + ev.timeline);
if (ev.timeline) {
    console.log("timeline.id: " + ev.timeline.id);
}
for (var prop in ev) {
    console.log("prop: " + prop);
}

