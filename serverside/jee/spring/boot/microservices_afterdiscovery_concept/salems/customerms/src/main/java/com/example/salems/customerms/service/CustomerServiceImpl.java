package com.example.salems.customerms.service;

import com.example.salems.customerms.dto.AddCustomerRequest;
import com.example.salems.customerms.dto.BuyProductRequest;
import com.example.salems.customerms.dto.CustomerDetails;
import com.example.salems.customerms.entity.Customer;
import com.example.salems.customerms.exceptions.CustomerNotFoundException;
import com.example.salems.customerms.repository.ICustomerRepository;
import com.example.salems.customerms.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepo;
   @Autowired
    private CustomerUtil customerUtil;

    @Override
    public CustomerDetails add(AddCustomerRequest requestData) {
        Customer  customer=new Customer();
        customer.setName(requestData.getName());
        customer=customerRepo.save(customer);
        return customerUtil.toCustomerDetails(customer);
    }

    @Override
    public CustomerDetails findCustomerDetailsById(long id) throws CustomerNotFoundException {
        Customer customer=findCustomerById(id);
        return customerUtil.toCustomerDetails(customer);
    }

    @Override
    public Customer findCustomerById(long id) throws CustomerNotFoundException {
        Optional<Customer>optional=customerRepo.findById(id);
        if(!optional.isPresent()){
            throw new CustomerNotFoundException("customer not found");
        }
        return optional.get();
    }

    @Override
    public  Customer update(Customer customer) throws CustomerNotFoundException {
        boolean exists=customerRepo.existsById(customer.getId());
        if(!exists){
            throw new CustomerNotFoundException("customer not found for id="+customer.getId());
        }
        return customerRepo.save(customer);
    }

    @Override
    public  void addProductToCustomer(BuyProductRequest request) throws CustomerNotFoundException {
      Customer customer= findCustomerById(request.getCustomerId());
       Set<Long>products= customer.getProducts();
       if(products==null){
           products=new HashSet<>();
           customer.setProducts(products);
       }
        products.add(request.getProductId());
        customer=update(customer);

    }


}
