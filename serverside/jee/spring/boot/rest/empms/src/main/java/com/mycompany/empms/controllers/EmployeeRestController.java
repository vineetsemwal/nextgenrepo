package com.mycompany.empms.controllers;

import com.mycompany.empms.entity.Employee;
import com.mycompany.empms.exceptions.EmployeeNotFoundException;
import com.mycompany.empms.exceptions.InvalidEmployeeAgeException;
import com.mycompany.empms.exceptions.InvalidEmployeeIdException;
import com.mycompany.empms.exceptions.InvalidEmployeeNameException;
import com.mycompany.empms.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employees")
@RestController
public class EmployeeRestController {

    @Autowired
    private IEmployeeService service;

    @GetMapping("/byid/{id}")
    public Employee fetchById(@PathVariable long id) throws Exception {
      Employee emp=service.findById(id);
      return emp;
    }

    @GetMapping("/all")
    public List<Employee> fetchAll(){
        List<Employee>list=service.findAll();
        return list;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    //@RequestMapping(value = "/add",method= RequestMethod.POST)
    public Employee add(@RequestBody Employee emp) throws Exception{
       Employee response =service.add(emp.getName(),emp.getAge());
       return response;
    }

    //@RequestMapping(value = "/add",method= RequestMethod.PUT)
    @PutMapping("/update")
    public Employee update(@RequestBody Employee emp) throws Exception{
        Employee response =service.update(emp);
        return response;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException e){
        return e.getMessage();
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public String handleInvalidEmployeeName(InvalidEmployeeNameException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEmployeeAgeException.class)
    public String handleInvalidEmployeeAge(InvalidEmployeeAgeException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public String handleInvalidEmployeeId(InvalidEmployeeIdException e){
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public String handleInBlanketWay(Exception e){
        return e.getMessage();
    }


}