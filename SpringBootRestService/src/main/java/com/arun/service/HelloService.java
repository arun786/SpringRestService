package com.arun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.bean.Country;
import com.arun.dao.IHelloDAO;

@Service
public class HelloService implements IHelloService {
	
	@Autowired
	private IHelloDAO iHelloDAO;

	public List<Country> getCountry() {
		List<Country> lst = iHelloDAO.getCountry();
		return lst;
	}

	@Override
	public Country getDetailsOfCountry(String country) {
		return iHelloDAO.getDetailsOfCountry(country);
	}

	@Override
	public boolean deleteCountry(String country) {
		return iHelloDAO.deleteCountry(country);
	}

	@Override
	public boolean addCountry(Country country) {
		// TODO Auto-generated method stub
		return iHelloDAO.addCountry(country);
	}
}
