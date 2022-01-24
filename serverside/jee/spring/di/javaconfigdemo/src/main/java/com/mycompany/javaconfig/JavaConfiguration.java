package com.mycompany.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
}
