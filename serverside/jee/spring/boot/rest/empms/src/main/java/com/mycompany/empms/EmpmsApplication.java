package com.mycompany.empms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * equivalent to these annotations
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 */
@SpringBootApplication
public class EmpmsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(EmpmsApplication.class, args);
	   // FrontEndClient frontend=context.getBean(FrontEndClient.class);
	   // frontend.render();
	}

}
