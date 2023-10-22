package com.app.exception_handler;

@SuppressWarnings("serial")
public class UserAlreadyExists extends RuntimeException {
	public UserAlreadyExists(String mesg) {
		super(mesg);
	}
}
