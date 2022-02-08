package com.example.customerms.repositories;

import com.example.customerms.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository extends MongoRepository<Customer,String> {
}
