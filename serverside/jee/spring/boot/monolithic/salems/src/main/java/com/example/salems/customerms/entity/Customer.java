package com.example.salems.customerms.entity;

import com.example.salems.productms.entity.Product;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name="customers_data" )
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Long id;
    private String name;
    @JoinTable(name="customers_products",joinColumns=@JoinColumn(name="customer_id"),
            inverseJoinColumns = @JoinColumn(name="product_id"))
    @OneToMany
    private Set<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
