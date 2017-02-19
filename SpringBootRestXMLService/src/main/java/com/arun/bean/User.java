package com.arun.bean;

import org.springframework.http.HttpStatus;

public class User {
	private String id;
	private String name;
	private String age;

	public User() {
		super();
	}

	public User(String id, String name, String age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
