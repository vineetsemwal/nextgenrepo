package collectiondemos.mapex;

import java.util.Comparator;

public class DescendingIdComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer key1, Integer key2) {
        return key2-key1;
    }
}
