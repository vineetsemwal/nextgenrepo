package com.example.salems.productms.util;

import com.example.salems.customerms.entity.Customer;
import com.example.salems.productms.dto.AddProductRequest;
import com.example.salems.productms.dto.BoughtProductDetails;
import com.example.salems.productms.dto.ProductDetails;
import com.example.salems.productms.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductUtil {

    public Product toProduct(AddProductRequest request){
        Product product = new Product();
        BeanUtils.copyProperties(request,product);
        return product;
    }

    public ProductDetails toProductDetails(Product product) {
      ProductDetails desired=new ProductDetails();
      BeanUtils.copyProperties(product, desired);
      return desired;
    }

    public BoughtProductDetails toBoughtProductDetails(Product product, Customer customer, int purchasedUnits) {
     BoughtProductDetails desired=new BoughtProductDetails();
     desired.setCustomerId(customer.getId());
     desired.setCustomerName(customer.getName());
     desired.setProductId(product.getId());
     desired.setProductName(product.getProductName());
     desired.setPrice(product.getPrice());
     desired.setPurchasedUnits(purchasedUnits);
     return desired;
    }
}
