package com.mycompany.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class Demo1 {
    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        demo.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empms");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Employee emp1 = new Employee("rameshbabu", 21);
        Employee emp2 = new Employee("deepak", 22);

        em.persist(emp1);
        //merge here will insert new record because emp2 doesn't contain id which exist in one of table recod
        emp2 = em.merge(emp2);
        transaction.commit();
        System.out.println("employee inserted");
        display(emp1);
        display(emp2);
        long id = emp1.getId();
        Employee found = em.find(Employee.class, id);
        System.out.println("employee fetched by id=" + id);
        display(found);

        EntityTransaction transaction2 = em.getTransaction();
        transaction2.begin();
        emp1.setAge(28);
        //merge here will update that record in table whch has id which is there in the object
        emp1 = em.merge(emp1);
        transaction.commit();
        System.out.println("employee details updated in db");
        display(emp1);

        em.close();
        emf.close();
    }


    public void display(Employee emp) {
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());
    }

}
