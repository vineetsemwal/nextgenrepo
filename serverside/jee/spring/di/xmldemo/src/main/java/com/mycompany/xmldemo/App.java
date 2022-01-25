package com.mycompany.xmldemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        //fetch bean by type (by data type of bean)
        Canvas canvas1=context.getBean(Canvas.class);
        canvas1.drawShape();

        IShape shape=context.getBean(Circle.class);
        System.out.println("shape is "+shape.getClass().getSimpleName());

        //fetch bean by name by which it is registered in container
        Canvas canvas2=context.getBean("canvas",Canvas.class);
        canvas2.drawShape();

        boolean isCanvasObjectsSame=canvas1==canvas2;
        System.out.println("is canvas objects same?"+isCanvasObjectsSame);

        Circle circle2=context.getBean("circle",Circle.class);
        System.out.println("circle ="+circle2);

        System.out.println("before container is closed");
        context.close();
        System.out.println("after container is closed");


    }
}
