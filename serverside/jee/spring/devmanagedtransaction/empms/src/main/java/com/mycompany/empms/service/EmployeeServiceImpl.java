package com.mycompany.empms.service;

import com.mycompany.empms.dao.IEmployeeDao;
import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.exceptions.InvalidEmployeeAgeException;
import com.mycompany.empms.exceptions.InvalidEmployeeIdException;
import com.mycompany.empms.exceptions.InvalidEmployeeNameException;
import com.mycompany.empms.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao dao;

    @Autowired
    private JpaUtil jpaUtil;

    public EntityManager getEntityManager() {
        return jpaUtil.getOrCreateEntityManager();
    }


    @Override
    public Employee add(String name, int age) throws InvalidEmployeeNameException, InvalidEmployeeAgeException {
        validateName(name);
        validateAge(age);
        EntityTransaction transaction = getEntityManager().getTransaction();
        transaction.begin();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        dao.add(employee);
        transaction.commit();
        return employee;
    }

    @Override
    public Employee update(Employee employee)
            throws InvalidEmployeeNameException, InvalidEmployeeAgeException, EmployeeNotFoundException, InvalidEmployeeIdException {
        validateName(employee.getName());
        validateAge(employee.getAge());
        validateId(employee.getId());
        boolean exists = dao.existById(employee.getId());
        if (!exists) {
            throw new EmployeeNotFoundException("employee not found for id=" + employee.getId());
        }
        EntityTransaction transaction=getEntityManager().getTransaction();
        transaction.begin();
        dao.update(employee);
        transaction.commit();
        return employee;
    }

    @Override
    public Employee findById(long id) throws InvalidEmployeeIdException, EmployeeNotFoundException {
        validateId(id);
        Optional<Employee> optional = dao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new EmployeeNotFoundException("employee doesn't exist for id="+id);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    void validateId(long id) throws InvalidEmployeeIdException {
        if (id <= 0) {
            throw new InvalidEmployeeIdException("id can't be negative and zero");
        }
    }

    void validateName(String name) throws InvalidEmployeeNameException {
        if (name == null || name.isEmpty()) {
            throw new InvalidEmployeeNameException("name can't be null or empty");
        }
    }

    void validateAge(int age) throws InvalidEmployeeAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidEmployeeAgeException("age can't be be smaller than 18 or greater than 60");
        }
    }

}
