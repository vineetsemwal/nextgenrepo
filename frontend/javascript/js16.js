/**
 * rest usage
 */

let numbers=[1,2,3,4];

let [num1,,num3,num4]=numbers;

console.log(num1,  num3, num4);


let [num5,num6,...remaining]=numbers;

for(let num of remaining){
    console.log("num",num);
}
