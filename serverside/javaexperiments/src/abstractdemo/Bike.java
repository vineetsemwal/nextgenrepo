package abstractdemo;

public class Bike extends Vehicle{

    public Bike(String vehicleNo){
        super(vehicleNo);
    }

    @Override
    public void move() {
        System.out.println(getVehicleNo()+" moves liek a bike");
    }
}
