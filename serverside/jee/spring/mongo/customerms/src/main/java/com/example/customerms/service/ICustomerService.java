package com.example.customerms.service;

import com.example.customerms.entities.Customer;

public interface ICustomerService {


    Customer  add(String id, String name, int age);

    Customer findById(String id);


}
