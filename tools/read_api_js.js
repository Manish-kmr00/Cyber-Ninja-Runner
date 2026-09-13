var file = studio.system.getFile(":/Scripts/api.js");
if (file.open(studio.system.openMode.ReadOnly)) {
    var text = file.readText(file.size());
    file.close();
    var idx = text.indexOf("loopMode");
    while (idx !== -1) {
        console.log("loopMode at " + idx + ": " + text.substring(idx - 30, idx + 100));
        idx = text.indexOf("loopMode", idx + 1);
    }
}

