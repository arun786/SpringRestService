package com.arun.bean;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private int errorcode;
	private HttpStatus errordesc;
	private String message;

	public ErrorMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

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

}
