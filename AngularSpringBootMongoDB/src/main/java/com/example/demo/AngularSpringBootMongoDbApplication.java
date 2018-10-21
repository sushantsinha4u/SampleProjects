package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class AngularSpringBootMongoDbApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(AngularSpringBootMongoDbApplication.class, args);
	}
	
	

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
	                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
	                        "Access-Control-Request-Headers")
	                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
	                .allowCredentials(true).maxAge(3600);
	    }

	    
}
