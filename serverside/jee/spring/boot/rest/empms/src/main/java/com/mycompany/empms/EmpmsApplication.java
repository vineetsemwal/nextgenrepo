package com.mycompany.empms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


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

	/**
	 *
	 * for handling cross origin requests
	 */
	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource src=new UrlBasedCorsConfigurationSource();
		CorsConfiguration configuration=new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
		configuration.addAllowedOrigin("http://localhost:4200");
		configuration.addAllowedMethod("*");
		src.registerCorsConfiguration("/**",configuration);
		return new CorsFilter(src);
	}

}
