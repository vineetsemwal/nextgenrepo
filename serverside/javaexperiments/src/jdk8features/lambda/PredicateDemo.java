package jdk8features.lambda;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args){
        IEven predicate1=(num)->num%2==0;
        boolean isEven1=predicate1.isEven(10);
        System.out.println("iseven="+isEven1);
        Predicate<Integer> predicate2=(num)->num%2==0;
        boolean isEven2=predicate2.test(20);
        System.out.println("isEven2="+isEven2);

        IConcatLengthEven bi1=(msg, times)->{
            String result="";
            for(int i=0;i<times;i++){
                result=result+msg;
            }
           return result.length()%2==0;
        };
       boolean isEven3= bi1.isConcatLengthEven("hi",3);
        System.out.println("is length even"+isEven3);
        BiPredicate<String, Integer>bi2=(msg, times)->{
            String result="";
            for(int i=0;i<times;i++){
                result=result+msg;
            }
            return result.length()%2==0;
        };
        boolean isEven4=bi2.test("hi",5);
        System.out.println("is even="+isEven4);
    }
}
