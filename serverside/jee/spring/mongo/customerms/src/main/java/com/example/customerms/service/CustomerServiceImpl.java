package com.example.customerms.service;

import com.example.customerms.entities.Customer;
import com.example.customerms.exceoptions.CustomerNotFoundException;
import com.example.customerms.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl  implements ICustomerService{

    @Autowired
    private ICustomerRepository repo;

    @Override
    public Customer add(String id, String name, int age) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setAge(age);
        customer=repo.save(customer);
        return customer;
    }

    @Override
    public Customer findById(String id) {
       Optional<Customer> optional =repo.findById(id);
       if(!optional.isPresent()){
           throw new CustomerNotFoundException("customer not found for id="+id);
       }
       return optional.get();
    }
}
