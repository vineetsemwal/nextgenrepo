package com.example.salems.customerms.util;

import com.example.salems.customerms.dto.CustomerDetails;
import com.example.salems.customerms.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CustomerUtil {

    private static final Logger Log= LoggerFactory.getLogger(CustomerUtil.class);

    @Value("${productms.baseUrl}")
    private String baseProductMSUrl;

    @Autowired
    private RestTemplate restTemplate;

    public CustomerDetails toCustomerDetails(Customer customer) {
        CustomerDetails desired=new CustomerDetails();
        BeanUtils.copyProperties(customer,desired);
        Set<Long>products=customer.getProducts();
        if(products!=null && !products.isEmpty()) {
            Set<String>productsNames= fetchProductNames(products);
             desired.setProductsName(productsNames);
        }
        return desired;
    }


    public Set<String>fetchProductNames(Collection<Long>productsId){
        Optional<String> optional=productsId.stream()
                .map(productId->productId.toString())
                .reduce((strId1,strId2)->strId1+","+strId2);
        if(!optional.isPresent()){
            return new HashSet<>();
        }
        String csvProductsId=optional.get();
        Log.info("inside fetchProductNames, ids concat="+csvProductsId);
        String url=baseProductMSUrl+"/namesbyids/"+csvProductsId;
        String[]productsNames=restTemplate.getForObject(url,String[].class);
        Set<String>namesSet=Stream.of(productsNames).collect(Collectors.toSet());
        return namesSet;
    }

}
