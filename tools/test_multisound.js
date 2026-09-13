var ms = studio.project.create("MultiSound");
console.log("MultiSound created: " + ms);
for (var r in ms.relationships) {
    console.log("ms rel: " + r);
}
studio.project.deleteObject(ms);

