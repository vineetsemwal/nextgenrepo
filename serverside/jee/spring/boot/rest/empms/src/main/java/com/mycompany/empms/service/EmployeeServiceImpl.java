package com.mycompany.empms.service;

import com.mycompany.empms.dao.IEmployeeRepository;
import com.mycompany.empms.dto.AddEmployeeRequest;
import com.mycompany.empms.dto.EmployeeDetails;
import com.mycompany.empms.dto.UpdateEmployeeRequest;
import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.exceptions.InvalidEmployeeAgeException;
import com.mycompany.empms.exceptions.InvalidEmployeeIdException;
import com.mycompany.empms.exceptions.InvalidEmployeeNameException;
import com.mycompany.empms.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repo;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Transactional
    @Override
    public EmployeeDetails add(AddEmployeeRequest requestData) throws InvalidEmployeeNameException, InvalidEmployeeAgeException {
        validateName(requestData.getName());
        validateAge(requestData.getAge());
        Employee employee = new Employee();
        employee.setName(requestData.getName());
        employee.setAge(requestData.getAge());
        employee = repo.save(employee);
        EmployeeDetails desired = employeeUtil.toEmployeeDetails(employee);
        return desired;
    }

    @Transactional
    @Override
    public Employee update(Employee employee)
            throws InvalidEmployeeNameException, InvalidEmployeeAgeException, EmployeeNotFoundException, InvalidEmployeeIdException {
        validateName(employee.getName());
        validateAge(employee.getAge());
        validateId(employee.getId());
        boolean exists = repo.existsById(employee.getId());
        if (!exists) {
            throw new EmployeeNotFoundException("employee not found for id=" + employee.getId());
        }
        employee = repo.save(employee);
        return employee;
    }

    @Transactional
    @Override
    public EmployeeDetails updateEmployeeDetails(UpdateEmployeeRequest requestData) throws InvalidEmployeeNameException, InvalidEmployeeAgeException, EmployeeNotFoundException, InvalidEmployeeIdException {
        Employee employee = new Employee();
        employee.setId(requestData.getId());
        employee.setName(requestData.getName());
        employee.setAge(requestData.getAge());
        employee = update(employee);
        EmployeeDetails desired = employeeUtil.toEmployeeDetails(employee);
        return desired;
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findById(long id) throws InvalidEmployeeIdException, EmployeeNotFoundException {
        validateId(id);
        Optional<Employee> optional = repo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EmployeeNotFoundException("employee doesn't exist for id=" + id);
    }

    @Transactional(readOnly = true)
    @Override
    public EmployeeDetails findEmployeeDetailsById(long id) throws InvalidEmployeeIdException, EmployeeNotFoundException {
        Employee employee = findById(id);
        EmployeeDetails desired = employeeUtil.toEmployeeDetails(employee);
        return desired;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return repo.findAll();
    }

    @Override
    public List<EmployeeDetails> findAllEmployeeDetails() {
        List<Employee> employees = findAll();
        List<EmployeeDetails> desired = employeeUtil.toListEmployees(employees);
        return desired;
    }

    @Override
    public List<Employee> fetchByName(String name) {
        List<Employee> list = repo.findByName(name);
        return list;
    }

    @Override
    public List<Employee> fetchByNameAndAge(String name, int age) {
        List<Employee> list = repo.findByNameAndAge(name, age);
        return list;
    }

    @Override
    public List<Employee> fetchByAgeGreaterThan(int age) {
        List<Employee> list = repo.findByAgeGreaterThan(age);
        return list;
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
