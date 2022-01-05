/**
 * var problem: variabledeclared with var is available outside block
 */

function displayNumber(){
    console.log('number before if',num);
   if(true) {
      var num=20;
    }
    console.log("num is "+num);

}

displayNumber();