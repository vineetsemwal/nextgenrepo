package com.example.salems.customerms.service;

import com.example.salems.customerms.dto.AddCustomerRequest;
import com.example.salems.customerms.dto.BuyProductRequest;
import com.example.salems.customerms.dto.CustomerDetails;
import com.example.salems.customerms.entity.Customer;
import com.example.salems.customerms.exceptions.CustomerNotFoundException;

public interface ICustomerService {

    CustomerDetails add(AddCustomerRequest requestData);

    CustomerDetails findCustomerDetailsById(long id) throws CustomerNotFoundException;

    Customer findCustomerById(long id) throws CustomerNotFoundException;

    Customer update(Customer customer) throws CustomerNotFoundException;

    void addProductToCustomer(BuyProductRequest request) throws CustomerNotFoundException;

}
