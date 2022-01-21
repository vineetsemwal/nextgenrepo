package mapex;

import java.util.Comparator;

public class CompositeKeyComparator implements Comparator<CompositeKey> {
    @Override
    public int compare(CompositeKey key1, CompositeKey key2) {
        int compare=key1.compareTo(key2);
        return compare;
    }
}
