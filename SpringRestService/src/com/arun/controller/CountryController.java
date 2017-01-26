package com.arun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arun.bean.Country;
import com.arun.service.ICountryService;

@RestController
@RequestMapping("/cricket")
public class CountryController {

	@Autowired
	private ICountryService cricketService;

	/* url : localhost:8080/SpringRestService/cricket/ */

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getDefaultCricketer() {

		return cricketService.getCountryList();
	}

	public ICountryService getCricketService() {
		return cricketService;
	}

	public void setCricketService(ICountryService cricketService) {
		this.cricketService = cricketService;
	}

	/*
	 * o/p of the above method will be
	 * [{"id":"1","name":"India"},{"id":"2","name":"Australia"}]
	 */
	
	
	
}
