package jdk8features.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String args[]) {
        IStringConverter converter = (num) -> "" + num;
        String numStr = converter.convert(10);
        System.out.println("converter1:converted to string=" + numStr);

        Function<Integer, String> converter2 = (num) -> "" + num;
        String numStr2 = converter2.apply(20);
        System.out.println("converter2:converted to string=" + numStr2);

        IMultiplyConcatFunction biFun1 = (msg, times) -> {
            String result = "";
            for (int i = 0; i < times; i++) {
                result = result + msg;
            }
            return result;
        };
        String concat1 = biFun1.concatTimes("hello", 3);
        System.out.println("bi fun result 1=" + concat1);

        BiFunction<String, Integer, String> biFun2 = (msg, times) -> {
            String result = "";
            for (int i = 0; i < times; i++) {
                result = result + msg;
            }
            return result;
        };
        String concat2 = biFun2.apply("hi", 2);
        System.out.println("bi fun result 2=" + concat2);
    }
}
