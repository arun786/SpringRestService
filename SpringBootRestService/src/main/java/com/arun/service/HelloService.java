package com.arun.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService{

	public String getHelloWorld() {
		return "Hello from Service for Get ";
	}

	public String getHelloWorldPost() {
		return "Hello from Service for Post ";
	}

}
