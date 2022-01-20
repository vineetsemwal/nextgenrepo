package collectiondemos.setex;

import emp.Employee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEx {

    public static void main(String args[]){
        Set<Employee>set=new HashSet<>();
        Employee emp1=new Employee(1,"sripad",(byte)26);
        Employee emp2=new Employee(2,"rajeev",(byte)26);
        Employee emp3=new Employee(3,"ramana",(byte)26);
        set.add(emp3);
        set.add(emp1);
        set.add(emp2);
        set.add(emp2);
        int size=set.size();
        System.out.println("size="+size);
        System.out.println(set);
        for(Employee iterated:set){
            System.out.println("id="+iterated.getId()+" name="+iterated.getName());
        }
        Iterator<Employee>iterator=set.iterator();
        while(iterator.hasNext()){
            Employee iterated=iterator.next();
            System.out.println("id="+iterated.getId()+" name="+iterated.getName());
        }
    }
}
