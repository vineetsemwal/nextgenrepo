package genericdemo;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Util {


    public <T> Comparator<T> ascendingComparator(Class<T> typeClass){
        boolean isString=typeClass.equals(String.class);
        if (isString){
         return (Comparator<T>)new StringComparator();
        }
        boolean isNumber= typeClass.isAssignableFrom(Number.class);
        if(isNumber){
            return (Comparator<T>)new NumberComparator();
        }
        throw new UnsupportedOperationException("not supporting the type");
    }

    public <T> List<T> afterElement(List<T>list, T element){
        int index=list.indexOf(element);
        List<T>sublist=list.subList(index,list.size()-1);
        return sublist;
    }

}

class StringComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}


class NumberComparator implements Comparator<Number>{
    @Override
    public int compare(Number o1, Number o2) {
        double val1= o1.doubleValue();
        double val2=o2.doubleValue();
        double compareTo=val1-val2;
        if(compareTo==0){
            return 0;
        }
        if(compareTo>0){
            return 1;
        }
        return -1;
    }
}

