package com.example.salems.productms.util;

import com.example.salems.productms.dto.AddProductRequest;
import com.example.salems.productms.dto.BoughtProductDetails;
import com.example.salems.productms.dto.BuyProductRequest;
import com.example.salems.productms.dto.ProductDetails;
import com.example.salems.productms.entity.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductUtil {

    @Value("${customerms.basUrl}")
    private String baseCustomerMSUrl;

    @Autowired
    private RestTemplate restTemplate;

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

    public BoughtProductDetails toBoughtProductDetails(Product product, long customerId, int purchasedUnits) {
     BoughtProductDetails desired=new BoughtProductDetails();
     desired.setCustomerId(customerId);
     //desired.setCustomerName(customer.getName());
     desired.setProductId(product.getId());
     desired.setProductName(product.getProductName());
     desired.setPrice(product.getPrice());
     desired.setPurchasedUnits(purchasedUnits);
     return desired;
    }


    public void addProductToCustomer(BuyProductRequest request){
        String url= baseCustomerMSUrl +"/product/add";
        restTemplate.put(url,request);
    }

}
