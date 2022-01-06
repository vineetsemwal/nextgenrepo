
function add(num1, num2){
    console.log("inside add"); 
 let promise=new Promise((resolve, reject)=>{

    if(!num1 || !num2){
        reject(new Error("num1 or num2 is undefined"));
    }

    let result=num1+num2;
    resolve(result);

 });
    
    return promise;
 }
 
 function useAdd(){
 console.log("promise to be created");    
 let promise=add(10,20);
 console.log("promise created");
 const successHandler=result=>{
    console.log("result is available ",result);
    };
 const errHandler=   err=>{
    console.log("error was there");
    console.log(err.message);
};
 promise.then(successHandler,errHandler);
 console.log("bye");
 }
 
 useAdd();
 