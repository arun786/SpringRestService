package com.arun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Country> getCountry() {
		return helloService.getCountry();
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Country getDetailsOfCountry(@RequestBody(required = true) String country) {
		return helloService.getDetailsOfCountry(country);
	}

	@RequestMapping(value = "/get/country", method = RequestMethod.GET)
	public Country getDetailsOfCountryViaGetRequest(@RequestParam(value = "country") String country) {
		return helloService.getDetailsOfCountry(country);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public boolean deleteCountry(@RequestBody(required = true) String country) {
		return helloService.deleteCountry(country);
	}

	@RequestMapping(value = "/addCountry", method = RequestMethod.PUT)
	public boolean addCountry(@RequestBody(required = true) Country country) {
		return helloService.addCountry(country);
	}

	@RequestMapping(value = "/addCountrywithGet", method = RequestMethod.PUT)
	public Country addCountryWithResponse(@RequestBody(required = true) Country country) {
		boolean flag = helloService.addCountry(country);
		return flag == true ? helloService.getDetailsOfCountry(country.getName()) : null;
	}
}
