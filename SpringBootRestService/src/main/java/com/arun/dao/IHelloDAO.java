package com.arun.dao;

import java.util.List;

import com.arun.bean.Country;

public interface IHelloDAO {

	List<Country> getCountry();

	Country getDetailsOfCountry(String country);
	
	boolean deleteCountry(String country);
	
	boolean addCountry(Country country);
}
