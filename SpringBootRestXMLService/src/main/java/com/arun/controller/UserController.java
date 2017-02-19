package com.arun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.arun.bean.ErrorMessage;
import com.arun.bean.User;
import com.arun.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAllUser() {
		List<User> users = userService.findAllUser();
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAUser(@PathVariable("name") String name) {
		List<User> user = userService.findAUser(name);
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAUserBasedOnId(@PathVariable("id") String id) {
		User user = null;
		ErrorMessage errorMessage = null;
		try {
			user = userService.findAUserBasedOnId(id);
		} catch (EmptyResultDataAccessException e) {
			errorMessage = new ErrorMessage("User not found");
			errorMessage.setErrorcode(HttpStatus.NOT_FOUND.value());
			errorMessage.setErrordesc(HttpStatus.NOT_FOUND);
		}
		if (user == null) {
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
		}
		user.setErrorcode(HttpStatus.OK.value());
		user.setErrordesc(HttpStatus.OK);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
