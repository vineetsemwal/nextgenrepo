package collectiondemos.listex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListEx {

    public static void main(String[] args){
        List<String>oldList=new ArrayList<>();
        oldList.add("apple");
        oldList.add("mango");
        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        String val=list.get(1);
        System.out.println("value fetched at index 1"+val);
        int size=list.size();
        System.out.println("size="+size);
        list.add(0,"newstring");

        list.addAll(oldList);
        size=list.size();
        System.out.println("new size="+size);
        System.out.println("directly printing"+list);
        /*
        List<String>tobeRemoved=new ArrayList<>();
        for(String iterated:list){
           if(iterated.startsWith("th")){
               tobeRemoved.add(iterated);
           }
           System.out.println("iterated="+iterated);
        }
        list.removeAll(tobeRemoved);
        */
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
          String iterated =iterator.next();
            if(iterated.startsWith("th")){
                iterator.remove();
            }

        }

        System.out.println("directly printing"+list);

    }

}
