/*
variable declared using let is block scoped
*/

function displayNumber(){
    if(true) {
       let num=20;
     }
     console.log("num is "+num);
 
 }
 
 displayNumber();