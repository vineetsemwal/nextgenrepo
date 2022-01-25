package com.mycompany.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@PropertySource("classpath:app.properties")
@ComponentScan("com.mycompany.javaconfig")
@Configuration
public class JavaConfiguration {

/*    @Bean
    public Circle circle(){
        Circle circle=new Circle();
        return circle;
    }
*/
    @Autowired
    private Environment environment;

    @Bean
    public  Square square(){
        Square square=new Square();
        return square;
    }


    @PostConstruct
    public void afterInit(){
        System.out.println("inside afterInit of JavaConfiguration");
        int squareSide =environment.getProperty("square.side",Integer.class);
        int circleRadius=environment.getProperty("circle.radius",Integer.class);
        System.out.println("square side="+squareSide+" circle radius="+circleRadius);
    }


}
