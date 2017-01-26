package com.arun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.arun.bean.Country;
import com.arun.dao.ICountryDAO;

public class CountryService implements ICountryService {

	@Autowired
	private ICountryDAO cricketDAO;

	@Override
	public List<Country> getCountryList() {

		return cricketDAO.getCountryList();
	}

	public ICountryDAO getCricketDAO() {
		return cricketDAO;
	}

	public void setCricketDAO(ICountryDAO cricketDAO) {
		this.cricketDAO = cricketDAO;
	}

}
