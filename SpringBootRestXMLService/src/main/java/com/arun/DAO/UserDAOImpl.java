/**
 * 
 */
package com.arun.DAO;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.arun.bean.User;
import com.arun.mapper.UserRowMapper;

/**
 * @author Adwiti
 *
 */
@Repository
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

	private final String sql_query = "select id, name, age from user";
	private final String SQL_GET_QUERY = "select id, name, age from user where name = ?";

	@Autowired
	private DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<User> findAllUser() {
		List<User> users = getJdbcTemplate().query(sql_query, new UserRowMapper());
		return users;
	}

	@Override
	public List<User> findAUser(String name) {
		List<User> user = getJdbcTemplate().query(SQL_GET_QUERY, new Object[] { name }, new UserRowMapper());
		return user;
	}

}
