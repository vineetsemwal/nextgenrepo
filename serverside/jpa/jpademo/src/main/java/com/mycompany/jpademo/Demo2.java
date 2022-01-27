package com.mycompany.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class Demo2 {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("empms");
    private EntityManager em = emf.createEntityManager();


    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        demo.start();
    }

    public void start() {
        Employee emp1 = add("rameshbabu", 27);
        Employee emp2 = add("sripad", 26);
        System.out.println("employees inserted");
        display(emp1);
        display(emp2);

        Employee changed=update(emp2.getId(),"sripad",28);
        System.out.println("employee updated with id "+emp2.getId());
        display(changed);


        long empId = emp1.getId();
        Employee found = findById(empId);
        System.out.println("found employee by id " + empId);
        display(found);
        em.close();
        emf.close();
    }

    public Employee add(String name, int age) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee employee = new Employee(name, age);
        em.persist(employee);
        transaction.commit();
        return employee;
    }

    public Employee update(long empId, String name, int age) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee employee = em.find(Employee.class, empId);
        employee.setName(name);
        employee.setAge(age);
        employee = em.merge(employee);
        transaction.commit();
        return employee;
    }

    public Employee findById(long id) {
        Employee emp = em.find(Employee.class, id);
        return emp;
    }


    public void display(Employee emp) {
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());
    }

}
