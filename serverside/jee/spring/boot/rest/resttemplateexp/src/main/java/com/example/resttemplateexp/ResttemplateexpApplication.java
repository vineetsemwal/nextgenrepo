package com.example.resttemplateexp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ResttemplateexpApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(ResttemplateexpApplication.class, args);
	    RestTemplateExperiments experiments=context.getBean(RestTemplateExperiments.class);
		experiments.fireRequests();
	    context.close();
	}

}
