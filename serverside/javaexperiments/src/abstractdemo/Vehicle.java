package abstractdemo;

public abstract class Vehicle {
    private String vehicleNo;
    public Vehicle(String vehicleNo){
     this.vehicleNo=vehicleNo;
    }

    public String getVehicleNo(){
        return vehicleNo;
    }

   public  void move(){
        System.out.println("vehicle moves");
   }
}
