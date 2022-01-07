abstract class Vehicle{

    abstract move();

}
 
class Car extends Vehicle{

    move():string{
        console.log("car moves");
        return "car moves";
    }
}


class Bike extends Vehicle{

    move():void{
        console.log("bike moves");
    }
}

let car:Vehicle=new Car();
car.move();

let bike:Vehicle=new Bike();
bike.move();
