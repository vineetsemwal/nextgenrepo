package jdk8features.streamspidemos;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamApiDemo1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hi", "hello", "good", "bad");
        Stream<String> stream1 = list.stream();
        Predicate<String> predicate = (str) -> {
            System.out.println("inside predicate");
            return str.length() % 2 == 0;
        };


        /**
         * from a list of string , get total lenegth of even length string
         *
         */
        Stream<String> stream2 = stream1.filter(predicate);
        Function<String, Integer> function = str -> str.length();
        Stream<Integer> stream3 = stream2.map(function);
        Optional<Integer> optional = stream3.reduce((len1, len2) -> len1 + len2);
        optional.ifPresent(System.out::println);

        /**
         * from a list of string , get total lenegth of even length string
         * Done in a single statement
         */
        Optional<Integer> optional2 = list.stream()
                .filter(str -> str.length() % 2 == 0)
                .map(str -> str.length())
                .reduce((len1, len2) -> len1 + len2);

        optional2.ifPresent(System.out::println);

    }

    /*
    public int totalEvenLength( List<String> list){
       Stream<String> stream1= list.stream();
        Predicate<String>predicate=(str)->str.length()%2==0;
       Stream<String>stream2=stream1.filter(predicate);

    }*/
}
