package com.mycompany.empms.controllers;

import com.mycompany.empms.dto.AddEmployeeRequest;
import com.mycompany.empms.dto.EmployeeDetails;
import com.mycompany.empms.dto.UpdateEmployeeRequest;
import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.exceptions.InvalidEmployeeAgeException;
import com.mycompany.empms.exceptions.InvalidEmployeeIdException;
import com.mycompany.empms.exceptions.InvalidEmployeeNameException;
import com.mycompany.empms.service.IEmployeeService;
import com.mycompany.empms.util.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private EmployeeUtil util;

    @GetMapping("/byid/{id}")
    public EmployeeDetails fetchById(@PathVariable long id) throws Exception {
      Employee emp=service.findById(id);
      EmployeeDetails response=util.toEmployeeDetails(emp);
      return response;
    }

    @GetMapping("/all")
    public List<Employee> fetchAll(){
        List<Employee>list=service.findAll();
        return list;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    //@RequestMapping(value = "/add",method= RequestMethod.POST)
    public EmployeeDetails add(@RequestBody AddEmployeeRequest  requestData) throws Exception{
       Employee employee =service.add(requestData.getName(),requestData.getAge());
       EmployeeDetails response=util.toEmployeeDetails(employee);
       return response;
    }

    //@RequestMapping(value = "/add",method= RequestMethod.PUT)
    @PutMapping("/update")
    public EmployeeDetails update(@RequestBody UpdateEmployeeRequest requestDate) throws Exception{
        Employee employee=new Employee();
        employee.setId(requestDate.getId());
        employee.setName(requestDate.getName());
        employee.setAge(requestDate.getAge());
        employee=service.update(employee);
        EmployeeDetails response=util.toEmployeeDetails(employee);
        return response;
    }


}
