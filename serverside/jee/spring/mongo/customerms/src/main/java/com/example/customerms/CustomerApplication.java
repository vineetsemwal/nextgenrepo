package com.example.customerms;

import com.example.customerms.entities.Customer;
import com.example.customerms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
@SpringBootApplication
public class CustomerApplication {

    @Autowired
    private ICustomerService service;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CustomerApplication.class, args);
        CustomerApplication app = context.getBean(CustomerApplication.class);
        app.start();
        context.close();
    }

    public void start() {
        Customer customer1 = service.add("1", "scooby", 5);
        display(customer1);
        Customer customer2 = service.add("2", "tommy", 6);
        display(customer2);
        System.out.println("*********added 2 objects");
        Customer fetched = service.findById("1");
        display(fetched);
        System.out.println("*******fetched customer with id=1");
    }

    void display(Customer customer) {
        System.out.println(customer.getId() + "-" + customer.getName() + "-" + customer.getAge());
    }

}
