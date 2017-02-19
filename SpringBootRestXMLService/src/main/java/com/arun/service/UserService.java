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

}
