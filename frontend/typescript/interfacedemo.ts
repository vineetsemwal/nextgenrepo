
interface ICalculator{
    add(num1:number,num2:number):number;
}

class SamsungCalculator implements ICalculator{

    add(num1:number, num2:number):number{
      return num1+num2; 
    }

} 

class MototollaCalculator implements ICalculator{

   _sum(num1:number, num2:number){
       return num1+num2;
   }

    add(num1:number, num2:number):number{
      return this._sum(num1,num2); 
    }

} 

let calcy:ICalculator=new SamsungCalculator();
let result=calcy.add(1,2);
console.log(result);