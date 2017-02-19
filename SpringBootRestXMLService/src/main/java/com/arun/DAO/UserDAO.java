package com.arun.DAO;

import java.util.List;

import com.arun.bean.User;

public interface UserDAO {
	List<User> findAllUser();

	List<User> findAUser(String name);

	User findAUserBasedOnId(String id);

	String createAUser(User user);

	int updateUser(String id, User user);
}
