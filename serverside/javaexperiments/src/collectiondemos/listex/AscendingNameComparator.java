package collectiondemos.listex;

import emp.Employee;

import java.util.Comparator;

public class AscendingNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        String name1=emp1.getName();
        String name2=emp2.getName();
        int compareCode=name1.compareTo(name2);
        return compareCode;
    }
}
