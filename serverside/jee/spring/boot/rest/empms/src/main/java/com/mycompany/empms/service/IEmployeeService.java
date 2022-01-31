package com.mycompany.empms.service;

import com.mycompany.empms.dto.AddEmployeeRequest;
import com.mycompany.empms.dto.EmployeeDetails;
import com.mycompany.empms.dto.UpdateEmployeeRequest;
import com.mycompany.empms.entity.Department;
import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.*;

import java.util.List;

public interface IEmployeeService {

    EmployeeDetails add(AddEmployeeRequest request) throws InvalidEmployeeNameException, InvalidEmployeeAgeException, DepartmentNotFoundException;

    Employee update(Employee employee)
            throws InvalidEmployeeNameException, InvalidEmployeeAgeException, EmployeeNotFoundException, InvalidEmployeeIdException;

    EmployeeDetails updateEmployeeDetails(UpdateEmployeeRequest requestData)
            throws InvalidEmployeeNameException, InvalidEmployeeAgeException, EmployeeNotFoundException, InvalidEmployeeIdException;


    Employee findById(long id) throws InvalidEmployeeIdException, EmployeeNotFoundException;

    EmployeeDetails findEmployeeDetailsById(long id) throws InvalidEmployeeIdException, EmployeeNotFoundException;


    List<Employee> findAll();


    List<Employee> findAll(int pageNumber, int blockSize);

    List<EmployeeDetails> findAllEmployeeDetails();

    List<EmployeeDetails> findAllEmployeesDetail(int pageNumber, int blockSize);

    List<Employee> fetchByName(String name);

    List<Employee> fetchByNameAndAge(String name, int age);

    List<Employee>fetchByAgeGreaterThan(int age);

    List<EmployeeDetails>findEmployeeDetailsByDepartmentId(long departmentId) throws DepartmentNotFoundException;


    List<EmployeeDetails>findEmployeeDetailsByDepartmentName(String departmentName);
}
