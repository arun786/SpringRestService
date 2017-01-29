package com.arun.service;

import java.util.List;

import com.arun.bean.Country;

public interface IHelloService {
	List<Country> getCountry();
	
	Country getDetailsOfCountry(String country);
	
	public boolean deleteCountry(String country);
}
