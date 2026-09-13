var lr = studio.project.create("LoopRegion");
console.log("LoopRegion created: " + lr);
for (var p in lr) {
    console.log("lr prop: " + p);
}
for (var r in lr.relationships) {
    console.log("lr rel: " + r);
}
studio.project.deleteObject(lr);

