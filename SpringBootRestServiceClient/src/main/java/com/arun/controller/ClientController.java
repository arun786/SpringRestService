package com.arun.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.arun.bean.Country;


@Controller
public class ClientController {

	@RequestMapping(value = "/getCountry", method = RequestMethod.GET)
	public List<Country> getCountry() {
		final String uri = "http://localhost:8080/restservice/get";
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<Country> result = restTemplate.getForObject(uri, List.class);
		return result;
	}

}
