package com.example.salems.productms.repository;

import com.example.salems.productms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
