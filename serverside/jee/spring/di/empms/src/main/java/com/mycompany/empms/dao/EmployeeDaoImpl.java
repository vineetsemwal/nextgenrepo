package com.mycompany.empms.dao;

import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
    private Map<Long, Employee> store = new HashMap<Long, Employee>();

    private long generatedId;

    long generateId() {
        return ++generatedId;
    }

    @Override
    public void add(Employee employee) {
        long id = generateId();
        employee.setId(id);
        store.put(id, employee);
    }

    @Override
    public Employee updateAge(long empId, int newAge) {
        Employee emp = store.get(empId);
        emp.setId(newAge);
        return emp;
    }

    @Override
    public boolean existById(long id) {
        return store.containsKey(id);
    }

    @Override
    public Employee update(Employee employee) {
        store.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Optional<Employee> findById(long id) {
        boolean exists= store.containsKey(id);
        if(exists){
          Employee emp=store.get(id);
           return Optional.of(emp);
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        Collection<Employee> values = store.values();
        List<Employee> list = new ArrayList<>(values);
        return list;
    }
}
