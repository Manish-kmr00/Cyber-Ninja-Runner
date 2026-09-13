var testPath = "C:/Users/mailm/Documents/New folder/assets/audio/ui/ui_click_01.wav";
console.log("Testing importAudioFile with:", testPath);
var audioFile = studio.project.importAudioFile(testPath);
console.log("Result:", audioFile);
if (audioFile) {
    console.log("AudioFile path:", audioFile.getAssetPath());
    console.log("AudioFile id:", audioFile.id);
}
studio.project.save();

