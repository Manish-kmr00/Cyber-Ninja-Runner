var ev = studio.project.lookup("event:/Gameplay/Checkpoint");
console.log("Cleaning up Checkpoint...");
while (ev.groupTracks.length > 0) {
    studio.project.deleteObject(ev.groupTracks[0]);
}
while (ev.timeline.modules.length > 0) {
    studio.project.deleteObject(ev.timeline.modules[0]);
}
studio.project.save();
console.log("Checkpoint clean: tracks=" + ev.groupTracks.length + ", modules=" + ev.timeline.modules.length);

