package com.arun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/cricket")
public class CricketController {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String getCricketer(@PathVariable String name, ModelMap model) {
		model.addAttribute("cricket", name);
		return "list";
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getDefaultCricketer(ModelMap map) {
		map.addAttribute("cricket", "Sachin");
		return "list";
	}
}
