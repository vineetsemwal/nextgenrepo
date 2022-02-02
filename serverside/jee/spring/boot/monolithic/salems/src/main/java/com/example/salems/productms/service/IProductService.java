package com.example.salems.productms.service;

import com.example.salems.customerms.exceptions.CustomerNotFoundException;
import com.example.salems.productms.dto.AddProductRequest;
import com.example.salems.productms.dto.BoughtProductDetails;
import com.example.salems.productms.dto.BuyProductRequest;
import com.example.salems.productms.dto.ProductDetails;
import com.example.salems.productms.entity.Product;
import com.example.salems.productms.exceptions.ProductNotFoundException;

public interface IProductService {

   ProductDetails add(AddProductRequest request);

   Product findProductById(long productId) throws ProductNotFoundException;

   ProductDetails findProductDetailsById(long productId) throws ProductNotFoundException;

   BoughtProductDetails buyProduct(BuyProductRequest request) throws ProductNotFoundException, CustomerNotFoundException;
}
