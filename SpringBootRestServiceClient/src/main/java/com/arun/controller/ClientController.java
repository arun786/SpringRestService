package com.arun.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.arun.bean.Country;

@Controller
public class ClientController {

	@RequestMapping(value = "/getCountry", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Country> getCountry() {
		final String uri = "http://localhost:8080/restservice/get";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<Country> result = restTemplate.getForObject(uri, List.class);
		return result;
	}

	@RequestMapping(value = "/getCountryByName", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String getCountry(@RequestParam(value = "country") String country) {
		final String url = "http://localhost:8080/restservice/get/country?country={country}";
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, String.class, country);
	}

}
