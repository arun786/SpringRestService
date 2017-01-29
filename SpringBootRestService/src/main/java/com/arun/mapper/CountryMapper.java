package com.arun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arun.bean.Country;

public class CountryMapper implements RowMapper<Country> {

	public Country mapRow(ResultSet rs, int rownum) throws SQLException {

		Country c = new Country();
		c.setId(rs.getString(1));
		c.setName(rs.getString(2));
		c.setCapital(rs.getString(3));
		c.setCurrency(rs.getString(4));
		return c;
	}

}
