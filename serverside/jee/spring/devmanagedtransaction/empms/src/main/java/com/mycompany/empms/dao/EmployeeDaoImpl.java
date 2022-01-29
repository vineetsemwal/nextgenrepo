package com.mycompany.empms.dao;

import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {


    @Autowired
    private JpaUtil jpaUtil;

    public EntityManager getEntityManager(){
        return jpaUtil.getOrCreateEntityManager();
    }

    @Override
    public void add(Employee employee) {
        getEntityManager().persist(employee);
    }

    @Override
    public Employee updateAge(long empId, int newAge) {
       Employee employee = getEntityManager().find(Employee.class, empId);
        employee.setAge(newAge);
        employee=getEntityManager().merge(employee);
        return employee;
    }

    @Override
    public boolean existById(long id) {
        Optional<Employee>optional=findById(id);
        return optional.isPresent();
    }

    @Override
    public Employee update(Employee employee) {
      employee=getEntityManager().merge(employee);
      return employee;
    }

    @Override
    public Optional<Employee> findById(long id) {
      Employee employee= getEntityManager().find(Employee.class,id);
      if(employee==null){
          return Optional.empty();
      }
      return Optional.of(employee);
    }

    @Override
    public List<Employee> findAll() {
        String queryStr="from Employee";
        TypedQuery<Employee>query= getEntityManager().createQuery(queryStr,Employee.class);
        List<Employee> list = query.getResultList();
        return list;
    }
}
