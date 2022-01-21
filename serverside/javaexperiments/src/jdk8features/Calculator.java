package jdk8features;

public class Calculator implements ICalculator{

    @Override
    public int sub(int num1, int num2) {
        return num1-num2;
    }
}
