package jdk8features.lambda;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorDemo {

    public static void main(String[] args){
        ISquare operator1=num->num*num;
        int result1=operator1.square(5);
        UnaryOperator<Integer> operator2=num->num*num;
        int result2=operator2.apply(5);
        System.out.println("result1="+result1);
        System.out.println("resul2="+result2);

        /*
        UnaryOperator<Integer>operator3=UnaryOperator.identity();
        int result3=operator3.apply(10);
        System.out.println("reult3="+result3);
*/
        IAdder adder1=(num1,num2)->num1+num2;
        int addResult1=adder1.add(5,7);
        System.out.println("adder1: add result="+addResult1);
        BinaryOperator<Integer>adder2=(num1,num2)->num1+num2;
        int addResult2=adder2.apply(7,8);
        System.out.println("adder2: add result="+addResult2);



    }
}
