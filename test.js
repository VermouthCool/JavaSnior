"use strict";
var a = [1, 2, 3, 4, 5, 6, 7, 8, 9];
a.forEach(function (data, index) {
    console.log(data);
});
var b = a.map(function (data, index) {
    return data + 1;
});
var c = a.filter(function (data) {
    return data > 5;
});
var d = a.reduce(function (previousValue, currentValue, currentIndex, array) {
    return previousValue + currentIndex;
}, 0);
for (var _i = 0, b_1 = b; _i < b_1.length; _i++) {
    var number = b_1[_i];
    console.log(number);
}
for (var _a = 0, a_1 = a; _a < a_1.length; _a++) {
    var number = a_1[_a];
    console.log(number);
}
console.log(d);
