package com.mycompany.bidirectional;

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

        Address address=new Address();
        address.setCity("mumbai");
        address.setState("maha");
        address.setFlatNumber("201 B");
        em.persist(address);

        Employee employee=new Employee();
        employee.setName("rajiv");
        employee.setAge(28);
        employee.setAddress(address);


        em.persist(employee);
        address.setEmployee(employee);
        transaction.commit();
        System.out.println("******display employee details");

        displayEmployee(employee);

        System.out.println("********display address details");
        displayAddress(address);


        em.close();
        emf.close();
    }



    public void displayEmployee(Employee emp) {
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());
        Address address=emp.getAddress();
        displayAddress(address);
    }

    public void displayAddress(Address address){
        System.out.println("address-"+address.getId()+"-"+address.getCity()+"-"+address.getState()+"-"+address.getFlatNumber());
       Employee emp= address.getEmployee();
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());

    }



    void displayCollection(Collection<Employee> collection) {
        Consumer<Employee> consumer = this::displayEmployee;
        collection.stream().forEach(consumer);
    }

}
