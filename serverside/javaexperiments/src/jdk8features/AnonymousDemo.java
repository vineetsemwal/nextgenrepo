package jdk8features;

public class AnonymousDemo {

    public static void main(String args[]){
        ICalculator calculator=new ICalculator(){
            @Override
            public int sub(int num1, int num2) {
                return num1-num2;
            }

        };
        int subResult=calculator.sub(10,3);
        System.out.println("sub ="+subResult);
        int addResult=calculator.add(5,7);
        System.out.println("add result="+addResult);

    }
}
