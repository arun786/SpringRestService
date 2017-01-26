package com.arun.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.arun.bean.Country;
import com.arun.mapper.CountryMapper;

public class CountryDAO implements ICountryDAO {

	final String SELECT_SQL = "select id, name from country";

	private JdbcTemplate jdbc;

	public CountryDAO(DataSource ds) {
		jdbc = new JdbcTemplate(ds);
	}

	@Override
	public List<Country> getCountryList() {
		List<Country> lst = jdbc.query(SELECT_SQL, new CountryMapper());
		return lst;
	}

	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

}
