package com.arun.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.arun.bean.ErrorMessage;
import com.arun.bean.Response;
import com.arun.bean.User;
import com.arun.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<Response> findAllUser() {
		List<User> users = userService.findAllUser();
		Response response = new Response();
		if (users.isEmpty()) {
			return new ResponseEntity<Response>(HttpStatus.NO_CONTENT);
		}
		response.setUsers(users);
		response.setErrorcode(HttpStatus.OK.value());
		response.setErrordesc(HttpStatus.OK);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<Response> findAUser(@PathVariable("name") String name) {
		Response response = new Response();
		List<User> user = userService.findAUser(name);
		response.setUsers(user);
		response.setErrorcode(HttpStatus.OK.value());
		response.setErrordesc(HttpStatus.OK);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findAUserBasedOnId(@PathVariable("id") String id) {
		User user = null;
		ErrorMessage errorMessage = null;
		Response response = new Response();
		List<User> lstUser = new ArrayList<>();
		try {
			user = userService.findAUserBasedOnId(id);
			lstUser.add(user);
		} catch (EmptyResultDataAccessException e) {
			errorMessage = new ErrorMessage("User not found");
			errorMessage.setErrorcode(HttpStatus.NOT_FOUND.value());
			errorMessage.setErrordesc(HttpStatus.NOT_FOUND);
		}
		if (user == null) {
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
		}
		response.setErrorcode(HttpStatus.OK.value());
		response.setErrordesc(HttpStatus.OK);
		response.setUsers(lstUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/", method = RequestMethod.PUT)
	public ResponseEntity<?> createAUser(@RequestBody User user) {
		String response = userService.createAUser(user);
		if (response.equals("yes")) {
			ErrorMessage errorMessage = new ErrorMessage("User Created");
			errorMessage.setErrorcode(HttpStatus.OK.value());
			errorMessage.setErrordesc(HttpStatus.OK);
			return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.OK);
		}
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Unable to create a user"), HttpStatus.CONFLICT);
	}

	@RequestMapping(value = "/users/", method = RequestMethod.PUT)
	public ResponseEntity<?> createAUserWithAResponse(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		String response = userService.createAUser(user);
		if (response.equals("yes")) {
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucBuilder.path("/user/{name}").buildAndExpand(user.getName()).toUri());
			return new ResponseEntity<String>(header, HttpStatus.OK);
		}
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("Unable to create a user"), HttpStatus.CONFLICT);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
