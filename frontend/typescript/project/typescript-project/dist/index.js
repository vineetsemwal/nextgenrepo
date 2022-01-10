"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.startProject = void 0;
const Welcome_1 = require("./Welcome");
function startProject() {
    const shape = new Welcome_1.Circle(5);
    const canvas = new Welcome_1.Canvas(shape);
    canvas.drawArea();
}
exports.startProject = startProject;
startProject();
//library
//# sourceMappingURL=index.js.map