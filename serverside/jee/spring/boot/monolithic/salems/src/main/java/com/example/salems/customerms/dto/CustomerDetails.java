package com.example.salems.customerms.dto;

import java.util.Objects;
import java.util.Set;

public class CustomerDetails {
    private long id;
    private String name;
    private Set<String>productsName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getProductsName() {
        return productsName;
    }

    public void setProductsName(Set<String> productsName) {
        this.productsName = productsName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetails that = (CustomerDetails) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
