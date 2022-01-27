package com.mycompany.jpademo;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

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
        Employee emp3 = add("deepak", 27);
        Employee emp4 = add("piyush", 26);
        System.out.println("******employees inserted");
        display(emp1);
        display(emp2);
        display(emp3);
        display(emp4);
        Employee changed = update(emp2.getId(), "sripad", 28);
        System.out.println("*******employee updated with id " + emp2.getId());
        display(changed);

        long empId = emp1.getId();
        Employee found = findById(empId);
        System.out.println("*******found employee by id " + empId);
        display(found);

        long employeesCount=employeesCount();
        System.out.println("******displaying employees count ="+employeesCount);

        List<Employee> all = findAll();
        System.out.println("*******displaying all employees");
        displayCollection(all);

        List<Employee> employeesByNameSripad = findEmployeesByName("sripad");
        System.out.println("******displaying all employees who have name sripad");
        displayCollection(employeesByNameSripad);

        List<Employee> twoEmployees = findAll(2);
        System.out.println("*******displaying fetched two employees");
        displayCollection(twoEmployees);

        List<Employee> block1 = findAll(0, 2);
        System.out.println("******first block");
        displayCollection(block1);
        List<Employee> block2 = findAll(2, 2);
        System.out.println("******second block");
        displayCollection(block2);
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


    public long employeesCount(){
        String queryStr="select count(id) from Employee";
        TypedQuery<Long> query = em.createQuery(queryStr, Long.class);
        long result= query.getSingleResult();
        return result;
    }


    public List<Employee> findAll() {
        String queryStr = "from Employee";
        TypedQuery<Employee> query = em.createQuery(queryStr, Employee.class);
        List<Employee> list = query.getResultList();
        return list;
    }

    /**
     * @param firstIndex first index of the block
     * @param max        block size
     * @return list of employees (max size is block size)
     */
    public List<Employee> findAll(int firstIndex, int max) {
        String queryStr = "from Employee";
        TypedQuery<Employee> query = em.createQuery(queryStr, Employee.class);
        query.setMaxResults(max);
        query.setFirstResult(firstIndex);
        List<Employee> list = query.getResultList();
        return list;
    }

    /**
     * @param max block size
     * @return list of employees (max size is block size)
     */
    public List<Employee> findAll(int max) {
        String queryStr = "from Employee";
        TypedQuery<Employee> query = em.createQuery(queryStr, Employee.class);
        query.setMaxResults(max);
        List<Employee> list = query.getResultList();
        return list;
    }

    public List<Employee> findEmployeesByName(String name) {
        String queryStr = "from Employee where name=:namedParam";
        TypedQuery<Employee> query = em.createQuery(queryStr, Employee.class);
        query.setParameter("namedParam", name);
        List<Employee> list = query.getResultList();
        return list;
    }


    public void display(Employee emp) {
        System.out.println("emp-" + emp.getId() + "-" + emp.getName() + "-" + emp.getAge());
    }

    void displayCollection(Collection<Employee> collection) {
        Consumer<Employee> consumer = this::display;
        collection.stream().forEach(consumer);
    }

}
