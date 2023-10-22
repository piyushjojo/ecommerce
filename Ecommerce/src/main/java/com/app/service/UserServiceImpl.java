package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserInfoRepo;
import com.app.dao.IUserLoginRepo;
import com.app.dto.UserLoginDTO;
import com.app.dto.UserRegistrationDTO;
import com.app.entity.UserLoginInfo;
import com.app.entity.Users;
import com.app.exception_handler.UserAlreadyExists;
import com.app.exception_handler.UserDoesNotExist;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserLoginRepo userLoginRepo ; 
	
	@Autowired
	private IUserInfoRepo userInfoRepo ; 
	
	@Autowired
	private ModelMapper mapper;
	

	@Override
	public String userRegistration(UserRegistrationDTO userRegDTO) {
		Users user = userInfoRepo.findActiveUser(userRegDTO.getUsername(),userRegDTO.getEmail());
		UserLoginInfo userLoginInfo = null ; 
		if(user == null) {
			user = mapper.map(userRegDTO, Users.class);
			userLoginInfo = mapper.map(userRegDTO, UserLoginInfo.class);
			userLoginInfo.setPassword(userRegDTO.getPassword());
			userInfoRepo.save(user);
			userLoginRepo.save(userLoginInfo);
			return "User Added Successfully.";
		}
		throw new UserAlreadyExists("User already exist.");
	}

	@Override
	public String userLogin(UserLoginDTO userLoginDTO) {
		UserLoginInfo userLoginInfo = userLoginRepo.findActiveUser(userLoginDTO.getUsername(), mapper.map(userLoginDTO, UserLoginInfo.class).getHashedPassword());
		if(userLoginInfo !=null) {
			return "User Exists"; 
		}
		throw new UserDoesNotExist("User Does Not Exist");
	}

	@Override
	public Users getUserInfo(String username) {
		return userInfoRepo.findByUsername(username);
	}
	
	public boolean authenticateUser(String username, String password) {
        UserLoginInfo user = userLoginRepo.findByUsername(username);

        if (user != null && verifyPassword(user, password)) {
            return true; // Authentication successful
        }

        return false; // Authentication failed
    }

    private boolean verifyPassword(UserLoginInfo user, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = user.getHashedPassword();
        String salt = user.getSalt();

        // Verify the password by comparing the hashed input password with the stored hashed password
        return encoder.matches(password + salt, hashedPassword);
    }

}
