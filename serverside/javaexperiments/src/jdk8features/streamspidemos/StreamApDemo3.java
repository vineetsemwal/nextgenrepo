package jdk8features.streamspidemos;

import emp.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class StreamApDemo3 {

    public static void main(String[] args){

        List<Employee>list= Arrays.asList(
                new Employee(1,"rajeev",(byte)21),
                new Employee(2,"ramanna",(byte)22),
                new Employee(3,"remjith",(byte)23)

                );

        /**
         * convert from List<Employee> to List<String>
         *     list of employees to list of names
         */
       List<String> names =list.stream()
                .map(emp->emp.getName())
                .collect(Collectors.toList());

        names.forEach(System.out::println);

        /**
         * calculate total age of all employees
         */
       Optional<Integer> optional =list.stream().
                map(emp->(int)emp.getAge())
                .reduce((age1,age2)->age1+age2);

        optional.ifPresent(System.out::println);


        /**
         * convert List<Employee> to Map<Integer,Employee>
         */
        Function<Employee,Integer>keyFun=  emp->emp.getId();
        Function<Employee,Employee>valFun=UnaryOperator.identity();
        Map<Integer,Employee>map=list.stream().limit()
                .collect(Collectors.toMap(keyFun,valFun  ));

        map.keySet().stream().forEach(key->System.out.println("key="+key+"value="+ map.get(key)));



    }
}
