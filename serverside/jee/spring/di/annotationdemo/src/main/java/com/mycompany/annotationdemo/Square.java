package com.mycompany.annotationdemo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Square implements IShape{
    @Value("${square.side}")
    private double side;
    public void setSide(double side){
        this.side = side;
    }
    @Override
    public double area(){
        return side*side;
    }


    @PostConstruct
    public void afterInit(){
        System.out.println("inside afterInit of square"+side);
    }


    @PreDestroy
    public void onDestroy(){
        System.out.println("inside Square onDestroy");
    }


}
