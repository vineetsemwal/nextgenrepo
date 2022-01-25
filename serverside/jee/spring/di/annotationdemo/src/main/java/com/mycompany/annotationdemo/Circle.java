package com.mycompany.annotationdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Circle implements IShape {


    @Value("${circle.radius}")
    private double radius;

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("inside afterInit of Circle"+radius);
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("inside Circle onDestroy");
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
