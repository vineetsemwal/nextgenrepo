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

        Department department=new Department();
        department.setDeptName("dev");
        em.persist(department);

        Employee employee1=new Employee();
        employee1.setName("rajiv");
        employee1.setAge(28);
        em.persist(employee1);


        Employee employee2=new Employee();
        employee2.setName("ramanna");
        employee2.setAge(28);
        em.persist(employee2);

        Set<Employee> employees=department.getEmployees();
        if(employees==null){
            employees=new HashSet<>();
            department.setEmployees(employees);
        }
        employees.add(employee1);
        employees.add(employee2);
        em.merge(department);
        transaction.commit();
        System.out.println("****employees inserted");
        displayEmployee(employee1);
        displayEmployee(employee2);

        System.out.println("department inserted");
        displayDepartment(department);

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
