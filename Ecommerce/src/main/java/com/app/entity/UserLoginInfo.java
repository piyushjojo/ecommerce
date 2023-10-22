package com.app.entity;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "user_login_info")
@EqualsAndHashCode(callSuper = true)
public class UserLoginInfo extends  BaseEntity {

	private String username ; 
	private String email ;
    private String salt;
    private String hashedPassword;
    private String activeStatus; 

    
    public void setPassword(String password) {
    	this.salt = generateUniqueSalt();
    	this.hashedPassword = hashPassword(password, this.salt);
    }

    // Helper method to generate a unique random salt
    private String generateUniqueSalt() {
        return UUID.randomUUID().toString();
    }

    // Helper method to hash the password with the salt
    private String hashPassword(String password, String salt) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password + salt);
    }
}
