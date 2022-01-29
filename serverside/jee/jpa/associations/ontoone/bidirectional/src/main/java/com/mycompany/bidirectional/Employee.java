package com.mycompany.bidirectional;

import javax.persistence.*;
import java.util.Objects;

@Table(name="employees_data")
@Entity
public class Employee {
    @GeneratedValue
    @Id
    private Long id;
    @Column(name="empname",nullable=false)
    private String name;

    @Column(nullable=false)
    private int age;

    @JoinColumn(name="addr_id",nullable=false)
    @OneToOne
    private Address address;

    public Employee() {}

    public Employee(String name, int age){
        setName(name);
        setAge(age);
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
