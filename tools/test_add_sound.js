var ev = studio.project.lookup("event:/Gameplay/Checkpoint");
console.log("Event: " + ev.name);
var track = studio.project.create("GroupTrack");
track.mixerGroup.output = ev.mixer.masterBus;
track.mixerGroup.name = "Audio 1";
ev.relationships.groupTracks.add(track);
console.log("Track created and added!");

var sound = studio.project.create("SingleSound");
console.log("SingleSound created: " + sound);
sound.start = 0;
sound.length = 1.0;
track.relationships.modules.add(sound);
console.log("Sound added to track modules!");

var audioFiles = studio.project.model.AudioFile.findInstances();
console.log("AudioFiles found: " + audioFiles.length);
if (audioFiles.length > 0) {
    sound.audioFile = audioFiles[0];
    console.log("Assigned audioFile to sound: " + sound.audioFile.assetPath);
}

studio.project.save();
console.log("Saved successfully!");

