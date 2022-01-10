"use strict";
exports.__esModule = true;
exports.startProject = void 0;
var Welcome_1 = require("./Welcome");
function startProject() {
    var shape = new Welcome_1.Circle(5);
    var canvas = new Welcome_1.Canvas(shape);
    canvas.drawArea();
}
exports.startProject = startProject;
startProject();
//library
