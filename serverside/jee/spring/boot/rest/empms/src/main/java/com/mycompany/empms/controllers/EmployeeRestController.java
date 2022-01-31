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

    //@RequestMapping(value="/byid/{id}", method=RequestMethod.GET)
    @GetMapping("/byid/{id}")
    public EmployeeDetails fetchById(@PathVariable long id) throws Exception {
      EmployeeDetails response=service.findEmployeeDetailsById(id);
      return response;
    }

    @GetMapping("/bydeptid/{deptId}")
    public List<EmployeeDetails>findEmployeesByDepartmentId(@PathVariable long deptId) throws Exception{
      return  service.findEmployeeDetailsByDepartmentId(deptId);
    }

    @GetMapping("/bydeptname/{deptName}")
    public List<EmployeeDetails>findEmployeesByDepartmentId(@PathVariable String deptName){
       return service.findEmployeeDetailsByDepartmentName(deptName);
    }

    @GetMapping("/all")
    public List<EmployeeDetails> fetchAll(){
        List<EmployeeDetails>list=service.findAllEmployeeDetails();
        return list;
    }

    @GetMapping("/all/paging/{pageNumber}/{blockSize}")
    public List<EmployeeDetails> fetchAllByPaging(@PathVariable int pageNumber,@PathVariable() int blockSize){
        List<EmployeeDetails>list=service.findAllEmployeesDetail( pageNumber, blockSize);
        return list;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    //@RequestMapping(value = "/add",method= RequestMethod.POST)
    public EmployeeDetails add(@RequestBody AddEmployeeRequest  requestData) throws Exception{
       EmployeeDetails response =service.add(requestData);
       return response;
    }

    //@RequestMapping(value = "/add",method= RequestMethod.PUT)
    @PutMapping("/update")
    public EmployeeDetails update(@RequestBody UpdateEmployeeRequest requestData) throws Exception{
        EmployeeDetails response=service.updateEmployeeDetails(requestData);
        return response;
    }



}
