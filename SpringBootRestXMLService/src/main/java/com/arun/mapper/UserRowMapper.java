/**
 * 
 */
package com.arun.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.arun.bean.User;

/**
 * @author Adwiti
 *
 */
public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User u = new User();
		u.setId(rs.getString(1));
		u.setName(rs.getString(2));
		u.setAge(rs.getString(3));
		return u;
	}

}
