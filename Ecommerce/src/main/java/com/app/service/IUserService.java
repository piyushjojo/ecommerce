package com.app.service;

import com.app.dto.UserLoginDTO;
import com.app.dto.UserRegistrationDTO;
import com.app.entity.Users;


public interface IUserService {

	String userRegistration(UserRegistrationDTO userRegDTO);
	
	String userLogin(UserLoginDTO userLoginDTO);

	Users getUserInfo(String username);

	boolean authenticateUser(String username, String password);
	
}
