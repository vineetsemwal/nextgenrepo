package collectiondemos.listex;

import emp.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListEx2 {

    public static void main(String[] args){
        List<Employee>list=new ArrayList<>();
        Employee emp1=new Employee(1,"sripad",(byte)26);
        Employee emp2=new Employee(2,"rajeev",(byte)26);
        Employee emp3=new Employee(3,"ramana",(byte)26);
        list.add(emp3);
        list.add(emp1);
        list.add(emp2);
       // Collections.sort(list,);
        Comparator<Employee>comparator=new AsscendingEmployeeIdComparator();
        list.sort(comparator);
        System.out.println(list);

        list.sort(new AscendingNameComparator());
        System.out.println(list);

    }
}
