package optionaldemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class OperatorDemo2 {
    public static void main(String args[]){
        Optional<Integer> option = Optional.of(21);
        int val = option.filter( x -> option.isPresent() && x%2 == 0 ).orElse(0);
        int val2 = option.filter( x -> option.isPresent())
                .filter((x)-> x%2 == 0 ).
                orElse(0);

        System.out.println(val);
        System.out.println(val2);

    }
}
