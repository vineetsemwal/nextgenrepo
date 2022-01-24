package com.mycompany.javaconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Canvas {


    @Qualifier("square")
    @Autowired
    private IShape shape;

    public void setShape(IShape shape){
        this.shape = shape;
    }

    public void drawShape(){
        double area= shape.area();
        System.out.println("drawing shape"+area +" "+shape.getClass().getSimpleName());
    }

}
