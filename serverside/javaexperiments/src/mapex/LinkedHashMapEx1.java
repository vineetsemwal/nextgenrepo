package mapex;

import emp.Employee;

import java.util.*;

public class LinkedHashMapEx1 {
    public static void main(String[] args){
       //keys are unique, values can be duplicated
        Map<Integer, Employee>map=new LinkedHashMap<>();
        Employee emp1=new Employee(1,"rishwanth",(byte)25);
        Employee emp2=new Employee(2,"ramanna",(byte)25);
        Employee emp3=new Employee(3,"vinay",(byte)25);
        map.put(3,emp3);
        map.put(1,emp1);
        map.put(2,emp2);
        map.put(2,emp2);
        System.out.println(map);
        int size=map.size();
        System.out.println("size of map="+size);
        Employee fetchedForKey1=map.get(1);
        System.out.println("fetched for key 1 , value="+fetchedForKey1);
        System.out.println("iterating on keys below");
        Set<Integer> keys= map.keySet();
       for (Integer key:keys){
          Employee iterated= map.get(key);
           System.out.println("key="+key+" value="+iterated);
       }
       map.remove(1);
        System.out.println("rmoving entry with key 1");
       size=map.size();
        System.out.println("map size after removing entry= "+size);
        System.out.println("iterating on values below");
        Collection<Employee> values=map.values();
       for(Employee iterated:values){
           System.out.println("value "+iterated);
       }
        System.out.println("iterating on entries below");
      Set<Map.Entry<Integer,Employee>>entries= map.entrySet();
      for(Map.Entry<Integer,Employee> entry:entries){
          Integer key=entry.getKey();
          Employee value=entry.getValue();
          System.out.println("key="+key+"value="+value);
      }

    }
}
