package interfacedemo;

public class MototollaCalculator implements ICalculator{

    public int sum(int num1, int num2){
        return num1+num2;
    }

    @Override
    public int add(int num1, int num2) {
        return sum(num1,num2);
    }
}
