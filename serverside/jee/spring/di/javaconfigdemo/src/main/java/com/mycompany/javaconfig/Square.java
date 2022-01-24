package com.mycompany.javaconfig;


import org.springframework.stereotype.Component;

@Component
public class Square implements IShape{
    private double side;
    public void setSide(double side){
        this.side = side;
    }
    @Override
    public double area(){
        return side*side;
    }

}
