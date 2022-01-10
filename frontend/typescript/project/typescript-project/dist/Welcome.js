"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Circle = exports.Square = exports.Canvas = void 0;
class Canvas {
    constructor(shape) {
        this.shape = shape;
    }
    drawArea() {
        const area = this.shape.area();
        console.log("drawing area ", area);
    }
}
exports.Canvas = Canvas;
class Square {
    constructor(side) {
        this.side = side;
    }
    area() {
        return this.side * this.side;
    }
}
exports.Square = Square;
class Circle {
    constructor(radius) {
        this.radius = radius;
    }
    area() {
        return 3.14 * this.radius * this.radius;
    }
}
exports.Circle = Circle;
//# sourceMappingURL=Welcome.js.map