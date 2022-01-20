package collectiondemos.listex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {

    public static void main(String[] args){
        List<String>fruits=new ArrayList<>();
        fruits.add("apple");
        fruits.add("mango");
        List<String> list=new LinkedList<>();
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("three");
        String val=list.get(1);
        System.out.println("value fetched at index 1"+val);
        int size=list.size();
        System.out.println("size="+size);
        list.add(0,"newstring");
        list.addAll(fruits);
        size=list.size();
        System.out.println("new size="+size);
        System.out.println("directly printing"+list);

        boolean checkOneExist=list.contains("one");
        System.out.println("check one exists ="+checkOneExist);

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
