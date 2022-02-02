package com.example.salems.customerms.util;

import com.example.salems.customerms.dto.CustomerDetails;
import com.example.salems.customerms.entity.Customer;
import com.example.salems.productms.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerUtil {
    public CustomerDetails toCustomerDetails(Customer customer) {
        CustomerDetails desired=new CustomerDetails();
        BeanUtils.copyProperties(customer,desired);
        Set<Product>products=customer.getProducts();
        if(products!=null) {
            Set<String> productsNames = products.
                    stream().map(product -> product.getProductName())
                    .collect(Collectors.toSet());
            desired.setProductsName(productsNames);
        }
        return desired;
    }
}
