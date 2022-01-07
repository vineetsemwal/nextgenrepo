/**
 *  any constant like lack will give color hex value, string value
 * + all the constants for a particular type
 *
 */
var Color = /** @class */ (function () {
    function Color(colorName, colorValue) {
        this.colorName = colorName;
        this.colorValue = colorValue;
    }
    Color.prototype.getColorName = function () {
        return this.colorName;
    };
    Color.prototype.getColorValue = function () {
        return this.colorValue;
    };
    Color.getAll = function () {
        return Color.colors;
    };
    Color.Black = new Color('Black', '#000');
    Color.White = new Color('White', "#fff");
    Color.colors = [Color.Black, Color.White];
    return Color;
}());
var black = Color.Black;
console.log("name =", black.getColorName(), "value", black.getColorValue());
console.log(black);
var white = Color.White;
console.log("name =", white.getColorName(), "value", white.getColorValue());
console.log(white);
console.log("all colors below");
var colors = Color.getAll();
for (var _i = 0, colors_1 = colors; _i < colors_1.length; _i++) {
    var color = colors_1[_i];
    console.log(color.getColorName(), color.getColorValue());
}
