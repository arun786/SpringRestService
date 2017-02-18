package com.arun.springBootMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = { "com.arun.controller", "com.arun.service", "com.arun.DAO" })
public class SpringApplicationXML {

	public static void main(String[] args) {

		SpringApplication.run(SpringApplicationXML.class, args);

	}

}
