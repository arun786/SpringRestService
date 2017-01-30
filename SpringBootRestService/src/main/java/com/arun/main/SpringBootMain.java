package com.arun.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = { "com.arun.controller", "com.arun.service", "com.arun.dao"})
public class SpringBootMain extends SpringBootServletInitializer{
	
	/*
	 * To create a war file 
	 * step 1 Extends SpringBootServletInitializer 
	 * step 2 override the configure method 
	 * step 3 change the jar file to war file in pom
	 */

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootMain.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMain.class, args);
	}
}
