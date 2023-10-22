package com.app.exception_handler;

@SuppressWarnings("serial")
public class UserDoesNotExist extends RuntimeException {
	public UserDoesNotExist(String mesg) {
		super(mesg);
	}
}
