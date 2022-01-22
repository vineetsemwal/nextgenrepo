package jdk8features.streamspidemos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatDemoEx {

    public static void main(String args[]){
        List<String>list1= Arrays.asList("apple","mango");
        List<String>list2=Arrays.asList("banana","grapes");

        List<List<String>>lists=new ArrayList<>();
        lists.add(list1);
        lists.add(list2);

        Function<List<String>, Stream<String>>function=list->list.stream();
        Stream<String>stream=lists.stream().
                flatMap(function);
        List<String>result=stream.collect(Collectors.toList());
        System.out.println("original list="+lists);
        System.out.println("result="+result);
    }
}
