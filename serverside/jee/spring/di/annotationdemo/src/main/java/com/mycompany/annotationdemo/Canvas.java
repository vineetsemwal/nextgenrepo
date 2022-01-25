package com.mycompany.annotationdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Scope("prototype")
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


    @PostConstruct
    public void afterInit(){
        System.out.println("inside afterInit of Canvas"+shape);
    }

    @PreDestroy
    public void onDestroy(){
        System.out.println("inside Canvas onDestroy");
    }



}
