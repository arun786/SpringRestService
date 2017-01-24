package com.arun.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getHelloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello " + name;

	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String getHelloWorldPost(@RequestBody String name) {
		return "Hello " + name;
	}
}
