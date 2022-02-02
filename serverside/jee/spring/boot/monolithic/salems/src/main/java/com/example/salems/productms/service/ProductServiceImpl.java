package com.example.salems.productms.service;

import com.example.salems.customerms.dto.CustomerDetails;
import com.example.salems.customerms.entity.Customer;
import com.example.salems.customerms.exceptions.CustomerNotFoundException;
import com.example.salems.customerms.service.ICustomerService;
import com.example.salems.productms.dto.AddProductRequest;
import com.example.salems.productms.dto.BoughtProductDetails;
import com.example.salems.productms.dto.BuyProductRequest;
import com.example.salems.productms.dto.ProductDetails;
import com.example.salems.productms.entity.Product;
import com.example.salems.productms.exceptions.ProductNotFoundException;
import com.example.salems.productms.repository.IProductRepository;
import com.example.salems.productms.util.ProductUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepo;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ProductUtil productUtil;

    @Override
    public ProductDetails add(AddProductRequest request) {
        Product product=productUtil.toProduct(request);
        product=productRepo.save(product);
        return productUtil.toProductDetails(product);
    }

    @Override
    public Product findProductById(long productId) throws ProductNotFoundException {
      Optional<Product>optional= productRepo.findById(productId);
      if(!optional.isPresent()){
          throw new ProductNotFoundException("product not found for id="+productId);
      }
      return optional.get();
    }

    @Override
    public ProductDetails findProductDetailsById(long productId) throws ProductNotFoundException {
        Product product =findProductById(productId);
        return productUtil.toProductDetails(product);
    }

    @Override
    public BoughtProductDetails buyProduct(BuyProductRequest request) throws ProductNotFoundException, CustomerNotFoundException {
       Product product=  findProductById(request.getProductId());
       int remainingUnits=product.getUnits()-request.getRequiredUnits();
       product.setUnits(remainingUnits);
       productRepo.save(product);
       Customer customer=customerService.findCustomerById(request.getCustomerId());
       Set<Product> products=customer.getProducts();
       if(products==null){
           products=new HashSet<>();
           customer.setProducts(products);
       }
        products.add(product);
       customer=customerService.update(customer);
       return productUtil.toBoughtProductDetails(product, customer,request.getRequiredUnits());

    }

}
