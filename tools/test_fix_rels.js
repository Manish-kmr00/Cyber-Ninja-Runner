var ev = studio.project.lookup("event:/Gameplay/Checkpoint");
var sound = studio.project.lookup("{0bf74d05-008a-426f-ac3a-a25022961f96}");
var track = studio.project.lookup("{36b1d0af-2150-422a-b2a6-47aaf00528d6}");

sound.audioTrack = track;
ev.timeline.relationships.modules.add(sound);
studio.project.save();
console.log("Fixed relationships successfully!");

