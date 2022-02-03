package com.example.salems.customerms.repository;

import com.example.salems.customerms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
