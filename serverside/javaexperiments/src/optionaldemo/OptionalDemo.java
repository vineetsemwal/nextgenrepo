package optionaldemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String args[]) {
        Optional<Integer> optional = Optional.of(100);
        if (optional.isPresent()) {
            Integer value = optional.get();
            System.out.println(value);
        } else {
            System.out.println("doesnt contain value");
        }

        OptionalDemo demo=new OptionalDemo();
        demo.caller();
    }

    void caller() {
        List<String> list = new ArrayList<>();
        list.add("hi");
        list.add("hello");
        Optional<String> optional = fetchElementStartingFromZoo(list);
        if (optional.isPresent()) {
            String value = optional.get();
            System.out.println(value.toUpperCase());
        } else {
            System.out.println("no element found");
        }
    }

    Optional<String> fetchElementStartingFromZoo(Collection<String> collection) {
        for (String iterated : collection) {
            if (iterated.startsWith("zoo")) {
                return Optional.of(iterated);
            }
        }
        return Optional.empty();
    }

    String fetchElementStartingFromZoo2(Collection<String> collection) {
        for (String iterated : collection) {
            if (iterated.startsWith("zoo")) {
                return iterated;
            }
        }
        return "";
    }

}
