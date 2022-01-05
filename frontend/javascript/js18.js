/**
 * spread operator
 */
 let arr1=[1,2,3,4];
let arr2=[5,6,7,8];

let arr3=[...arr1, ...arr2];
for (let num of arr3){
    console.log(num);
}
