package jdk8features.lambda;

import collectiondemos.listex.AscendingNameComparator;
import emp.Employee;
import exp.calcy.Calculator;

import java.util.ArrayList;
import java.util.function.*;

public class MethodReferenceDemo {

    public static void main(String[] args) {
        MethodReferenceDemo demo = new MethodReferenceDemo();
        Predicate<Integer> predicate = demo::isEven;
        boolean result1 = predicate.test(10);
        System.out.println("Predicate: is even usage" + result1);
        BinaryOperator<Integer> operator1 = MethodReferenceDemo::sub;
        int result2 = operator1.apply(5, 7);
        System.out.println("BinaryOperator:result of add " + result2);
        Calculator calculator = new Calculator();
        BinaryOperator<Integer> operator2 = calculator::add;

        Supplier<Calculator> calulatorCreateRef = Calculator::new;
        Calculator calculator2 = calulatorCreateRef.get();
        System.out.println("created calculator=" + calculator2);
        Supplier<ArrayList<Integer>> listSupplier = ArrayList::new;
        ArrayList<Integer> list = listSupplier.get();
        System.out.println("created list=" + list);

        IEmployeeCreator constrRef = Employee::new;
        Employee employee = constrRef.newEmployee(10, "rishwanth", (byte) 25);
        System.out.println("employee=" + employee);

    }

    static int sub(int num1, int num2) {
        return num1 - num2;
    }

    boolean isEven(int num) {
        return num % 2 == 0;
    }


}
