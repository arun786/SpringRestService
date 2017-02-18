package com.arun.DAO;

import java.util.List;

import com.arun.bean.User;

public interface UserDAO {
	List<User> findAllUser();
}
