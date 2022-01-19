package abstractdemo;

public class Car extends Vehicle{

    public Car(String vehicleNo){
        super(vehicleNo);
    }

    @Override
    public void move() {
     System.out.println(getVehicleNo()+" moves like a car");
    }
}
