package mapex;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomKeyDemo {

    public static void main(String[] args) {
        Comparator<CompositeKey> comparator = new CompositeKeyComparator();
        Map<CompositeKey, Student> map = new TreeMap<>(comparator);
        Student student1 = new Student("sachin", "tendulkar", 43);
        Student student2 = new Student("virat", "kohli", 30);
        CompositeKey key1 = new CompositeKey("sachin", "tendulkar");
        CompositeKey key2 = new CompositeKey("virat", "kohli");
        map.put(key2, student2);
        map.put(key1, student1);

        System.out.println("map=" + map);

    }
}
