var mod = studio.project.create("RandomizerModulator");
console.log("RandomizerModulator created: " + mod);
for (var p in mod) {
    console.log("mod prop: " + p);
}
studio.project.deleteObject(mod);

