var SamsungCalculator = /** @class */ (function () {
    function SamsungCalculator() {
    }
    SamsungCalculator.prototype.add = function (num1, num2) {
        return num1 + num2;
    };
    return SamsungCalculator;
}());
var MototollaCalculator = /** @class */ (function () {
    function MototollaCalculator() {
    }
    MototollaCalculator.prototype._sum = function (num1, num2) {
        return num1 + num2;
    };
    MototollaCalculator.prototype.add = function (num1, num2) {
        return this._sum(num1, num2);
    };
    return MototollaCalculator;
}());
var calcy = new SamsungCalculator();
var result = calcy.add(1, 2);
console.log(result);
