package com.example.salems.customerms.controller;

import com.example.salems.customerms.dto.AddCustomerRequest;
import com.example.salems.customerms.dto.CustomerDetails;
import com.example.salems.customerms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/byid/{id}")
    public CustomerDetails fetchCustomerById(@PathVariable long id) throws Exception{
        return customerService.findCustomerDetailsById(id);
    }

    @PostMapping("/add")
    public CustomerDetails add(@RequestBody AddCustomerRequest request){
        return customerService.add(request);
    }

}
