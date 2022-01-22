package jdk8features.streamspidemos;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamApiDemo2 {

    public static void main(String[] args){
        Stream<String> stream=Stream.of("hi","hello","good","hi");
        Stream<String>stream2=stream.distinct();
        Stream<String>stream3 =stream2.limit(4);
        Stream<String>stream4=stream3.sorted(String::compareTo);
        Stream<String>stream5=stream4.skip(1);
       // long count=stream5.count();
       // System.out.println(count);
       //Optional<String> optional =stream5.max(String::compareTo);
       stream5.forEach(System.out::println);

    }

}
