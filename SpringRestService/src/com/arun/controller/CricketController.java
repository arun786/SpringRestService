package com.arun.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arun.bean.Country;

@RestController
@RequestMapping("/cricket")
public class CricketController {

	/* url : localhost:8080/SpringRestService/cricket/ */

	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getDefaultCricketer() {

		Country c1 = new Country("1", "India");
		Country c2 = new Country("2", "Australia");

		List<Country> lstC1 = new ArrayList<>();
		lstC1.add(c1);
		lstC1.add(c2);
		return lstC1;
	}

	/*
	 * o/p of the above method will be
	 * [{"id":"1","name":"India"},{"id":"2","name":"Australia"}]
	 */
}
