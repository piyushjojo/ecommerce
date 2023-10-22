package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.UserLoginDTO;
import com.app.dto.UserProfileDTO;
import com.app.dto.UserRegistrationDTO;
import com.app.entity.Users;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {
		if (userService.authenticateUser(userLoginDTO.getUsername(), userLoginDTO.getPassword())) {
			return new ResponseEntity<>("Login successful. "+userLoginDTO.getUsername()+" looged in.", HttpStatus.OK);
		}
		return new ResponseEntity<>("Login failed", HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/profile")
	public ResponseEntity<?> getUserInfo(@RequestBody UserProfileDTO userProfileDTO) {
		Users user = userService.getUserInfo(userProfileDTO.getUsername());
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(new ApiResponse("user " + userProfileDTO.getUsername() + " does not exist."),
				HttpStatus.NOT_FOUND);

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRegistrationDTO userRegistrationDTO) {
		try {
			return new ResponseEntity<>(new ApiResponse(userService.userRegistration(userRegistrationDTO)),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ApiResponse("user registration failed."), HttpStatus.NOT_FOUND);
		}
	}
}
