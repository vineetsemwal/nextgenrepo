/**
 * es6 string improvement
 */
var text1= "hi \n hello";

var text2=`hi 
hello
bye`;

console.log("text1=",text1);
console.log("text2=",text2);

var uname='venkat';
var text3="hi "+ uname +" how are you?";
var text4=`hi ${uname} how are you?`;
console.log("text3="+text3);
console.log(`text4=${text4}`);
