package interfacedemo;

public class CalculatorMain {

    public static void main(String args[]){
        ICalculator calcy=new SamsungCalculator();
        int result=calcy.add(5,7);
        System.out.println("result="+result);
    }
}
