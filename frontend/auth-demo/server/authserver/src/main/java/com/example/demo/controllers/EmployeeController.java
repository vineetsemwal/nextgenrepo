package com.example.demo.controllers;

import com.example.demo.entity.Employee;
import com.example.demo.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    @Autowired
    private IAuthenticationService authService;

  @GetMapping("/byid/{id}")
  public Employee findEmployeeById(@PathVariable long id, HttpServletRequest request){
      String token=request.getHeader("token");
      authService.checkCredentialsByToken(token);
      Employee employee=new Employee();
      employee.setId(id);
      employee.setUsername("scooby");
      employee.setPassword("123");
      employee.setAge(27);
      return employee;
  }

    @GetMapping("/byusername/{username}")
    public Employee findEmployeeByUsername(@PathVariable String username, HttpServletRequest request){
        String token=request.getHeader("token");
        authService.checkCredentialsByToken(token);
        Employee employee=new Employee();
        employee.setId(1);
        employee.setUsername("scooby");
        employee.setPassword("123");
        employee.setAge(27);
        return employee;
    }

}
