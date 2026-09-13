console.log("=== FMOD Studio Script Test ===");
var events = studio.project.model.Event.findInstances();
console.log("Total events in project: " + events.length);
for (var i = 0; i < events.length; i++) {
    var ev = events[i];
    console.log("Event " + i + ": " + ev.name + " -> " + ev.getPath());
}

