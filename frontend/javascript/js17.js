/**
 * rest/spread operator
 */

function add(...numbers){

let sum=0;
for(let num of numbers){
    sum=sum+num;
}
return sum;
}

let result1=add(1,2);
let result2=add(1,2,3);

console.log("result1",result1,"result2",result2);