package com.mycompany.singledirectional;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Demo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("empms");
    private EntityManager em = emf.createEntityManager();


    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
    }

    public void start() {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Department department1=new Department();
        department1.setDeptName("dev");
        em.persist(department1);

        Department department2=new Department();
        department2.setDeptName("testing");
        em.persist(department2);


        Employee employee1=new Employee();
        employee1.setName("rajiv");
        employee1.setAge(28);
        em.persist(employee1);


        Employee employee2=new Employee();
        employee2.setName("ramanna");
        employee2.setAge(28);
        em.persist(employee2);


        Employee employee3=new Employee();
        employee3.setName("piyush");
        employee3.setAge(28);
        em.persist(employee3);

        Set<Employee> dept1Employees=department1.getEmployees();
        if(dept1Employees==null){
            dept1Employees=new HashSet<>();
            department1.setEmployees(dept1Employees);
        }
        dept1Employees.add(employee1);
        dept1Employees.add(employee2);

        em.merge(department1);

       Set<Employee>dept2Employees=department2.getEmployees();
        if(dept2Employees==null){
            dept2Employees=new HashSet<>();
            department2.setEmployees(dept2Employees);
        }

        dept2Employees.add(employee2);
        dept2Employees.add(employee3);
        em.merge(department2);

        transaction.commit();

        System.out.println("****employees inserted");
        displayEmployee(employee1);
        displayEmployee(employee2);

        System.out.println("*****department1 details");
        displayDepartment(department1);

        System.out.println("*****department2 details");
        displayDepartment(department2);

        em.close();
        emf.close();
    }



    public void displayEmployee(Employee emp) {
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());

    }

    public void  displayDepartment(Department department){
        System.out.println("department-"+department.getId()+" "+department.getDeptName());
        Set<Employee>employees=department.getEmployees();
        employees.stream().forEach(this::displayEmployee);
    }


    void displayCollection(Collection<Employee> collection) {
        Consumer<Employee> consumer = this::displayEmployee;
        collection.stream().forEach(consumer);
    }

}
