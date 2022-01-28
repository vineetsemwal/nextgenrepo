package com.mycompany.singledirectional;

import javax.persistence.*;
import java.util.Collection;
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

        Employee employee=new Employee();
        employee.setName("rajiv");
        employee.setAge(28);
        employee.setDepartment(department);

        em.persist(employee);

        transaction.commit();
        System.out.println("employee inserted");

        displayEmployee(employee);


        em.close();
        emf.close();
    }



    public void displayEmployee(Employee emp) {
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());
        Department dept=emp.getDepartment();
        System.out.println("department-"+dept.getId()+"-name-"+dept.getDeptName());
    }


    void displayCollection(Collection<Employee> collection) {
        Consumer<Employee> consumer = this::displayEmployee;
        collection.stream().forEach(consumer);
    }

}
