package com.arun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arun.service.IHelloService;

@RestController
public class HelloController {
	
	@Autowired
	private IHelloService helloService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getHelloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
		return helloService.getHelloWorld() + name;

	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String getHelloWorldPost(@RequestBody String name) {
		return helloService.getHelloWorldPost() + name;
	}
}
