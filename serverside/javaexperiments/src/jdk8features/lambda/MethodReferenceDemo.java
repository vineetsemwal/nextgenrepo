package jdk8features.lambda;

import collectiondemos.listex.AscendingNameComparator;
import emp.Employee;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceDemo {

    public static void main(String[] args){
        Consumer<String>consumer=System.out::println;
        consumer.accept("hello");

        MethodReferenceDemo demo=new MethodReferenceDemo();
        Predicate<Integer>predicate=demo::isEven;
        boolean result=predicate.test(10);
        System.out.println("result="+result);

        AscendingNameComparator nameComparator=new AscendingNameComparator();

       BiFunction<Employee,Employee,Integer> ascendingComparator=nameComparator::compare;
    }



    boolean isEven(int num){
        return num%2==0;
    }


}
