package com.arun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.DAO.UserDAO;
import com.arun.bean.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public List<User> findAllUser() {
		List<User> lstUser = userDAO.findAllUser();
		return lstUser;
	}

}
