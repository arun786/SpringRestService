package com.arun.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.arun.bean.Country;
import com.arun.mapper.CountryMapper;

@Repository
public class HelloDAO extends JdbcDaoSupport implements IHelloDAO {
	private final String SQL_Query = "select id, name, capital, currency from country";
	private final String SQL_QUERY_GET = "select id, name, capital, currency from country where name = ?";
	private final String SQL_QUERY_DELETE = "delete from country where name = ?";
	private final String UPDATE_QUERY = "insert into country (id,name,capital,currency) values(?,?,?,?)";

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialise() {
		setDataSource(dataSource);
	}

	public List<Country> getCountry() {
		List<Country> lst = getJdbcTemplate().query(SQL_Query, new CountryMapper());
		return lst;
	}

	@Override
	public Country getDetailsOfCountry(String country) {
		return getJdbcTemplate().queryForObject(SQL_QUERY_GET, new Object[] { country }, new CountryMapper());
	}

	@Override
	public boolean deleteCountry(String country) {
		int flag = getJdbcTemplate().update(SQL_QUERY_DELETE, country);
		return flag == 1 ? true : false;
	}

	@Override
	public boolean addCountry(Country country) {
		int flag = getJdbcTemplate().update(UPDATE_QUERY, country.getId(), country.getName(), country.getCapital(),
				country.getCurrency());
		return flag == 1 ? true : false;
	}
}
