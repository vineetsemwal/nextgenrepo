package com.example.apps.empms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient
@SpringBootApplication
public class EmpMainApplication {

	private static final Logger Log= LoggerFactory.getLogger(EmpMainApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EmpMainApplication.class, args);

		}



	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate(){
		RestTemplate restTemplate=new RestTemplate();
		return  restTemplate;
	}


}
