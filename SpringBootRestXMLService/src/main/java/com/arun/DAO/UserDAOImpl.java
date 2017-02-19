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
	private final String SQL_GET_QUERY_Id = "select id, name, age from user where id = ?";
	private final String SQL_INSERT_QUERY = "insert into user (name, age) values(?,?)";
	private final String UPDATE_QUERY = "update user set name = ?, age = ? where id = ?";
	private final String DELETE_QUERY_ID = "delete from user where id = ?";
	private final String DELETE_QUERY_NAME = "delete from user where name = ?";

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

	@Override
	public User findAUserBasedOnId(String id) {
		return getJdbcTemplate().queryForObject(SQL_GET_QUERY_Id, new Object[] { id }, new UserRowMapper());
	}

	@Override
	public String createAUser(User user) {
		int result = getJdbcTemplate().update(SQL_INSERT_QUERY, user.getName(), user.getAge());
		return result == 1 ? "yes" : "no";
	}

	@Override
	public int updateUser(String id, User user) {
		int response = getJdbcTemplate().update(UPDATE_QUERY, user.getName(), user.getAge(), user.getId());
		return response;
	}

	@Override
	public int deleteUserBasedOnId(String id) {
		return getJdbcTemplate().update(DELETE_QUERY_ID, id);
	}

	@Override
	public int deleteUserBasedOnName(String name) {
		return getJdbcTemplate().update(DELETE_QUERY_NAME, name);
	}

}
