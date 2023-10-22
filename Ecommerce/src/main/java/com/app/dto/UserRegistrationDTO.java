package com.app.dto;


import java.time.LocalDate;

import com.app.entity.Gender;
import com.app.entity.UserRole;

import lombok.Data;

@Data
public class UserRegistrationDTO {

	private String username ; 
	private String email ; 
	private String password ; 
	private String firstName ; 
	private String middleName ; 
	private String lastName ; 
	private Gender gender;
	private UserRole role ; 
	private LocalDate dob ; 
	private String activeStatus ; 
	private String phoneNo ;
	
}
