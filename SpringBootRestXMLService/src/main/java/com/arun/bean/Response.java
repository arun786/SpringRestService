package com.arun.bean;

import java.util.List;

import org.springframework.http.HttpStatus;

public class Response {
	private int errorcode;
	private HttpStatus errordesc;
	private List<User> users;

	public int getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}

	public HttpStatus getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(HttpStatus errordesc) {
		this.errordesc = errordesc;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
