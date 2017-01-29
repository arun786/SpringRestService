package com.arun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arun.bean.Country;
import com.arun.service.IHelloService;

@RestController
public class HelloController {

	@Autowired
	private IHelloService helloService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Country> getCountry(@RequestParam(value = "name", defaultValue = "World") String name) {
		return helloService.getCountry();
	}

}
