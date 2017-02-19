/**
 * 
 */
package com.arun.service;

import java.util.List;

import com.arun.bean.User;

/**
 * @author Adwiti
 *
 */
public interface UserService {

	List<User> findAllUser();

	List<User> findAUser(String name);

	User findAUserBasedOnId(String id);

	String createAUser(User user);

	int updateUser(String id, User user);

	int deleteUserBasedOnId(String id);

	int deleteUserBasedOnName(String name);

}
