"use strict";
exports.__esModule = true;
exports.Circle = exports.Square = exports.Canvas = void 0;
var Canvas = /** @class */ (function () {
    function Canvas(shape) {
        this.shape = shape;
    }
    Canvas.prototype.drawArea = function () {
        var area = this.shape.area();
        console.log("drawing area ", area);
    };
    return Canvas;
}());
exports.Canvas = Canvas;
var Square = /** @class */ (function () {
    function Square(side) {
        this.side = side;
    }
    Square.prototype.area = function () {
        return this.side * this.side;
    };
    return Square;
}());
exports.Square = Square;
var Circle = /** @class */ (function () {
    function Circle(radius) {
        this.radius = radius;
    }
    Circle.prototype.area = function () {
        return 3.14 * this.radius * this.radius;
    };
    return Circle;
}());
exports.Circle = Circle;
