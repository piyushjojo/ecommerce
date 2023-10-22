package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.UserLoginInfo;


public interface IUserLoginRepo extends JpaRepository<UserLoginInfo, Long> {
	
	@Query("select u from UserLoginInfo u where u.username = ?1 and u.hashedPassword = ?2 and u.activeStatus = 'Y'")
	UserLoginInfo findActiveUser(String username , String password);

	UserLoginInfo findByUsername(String username);

}
