package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Users;

public interface IUserInfoRepo extends JpaRepository<Users, Long> {

	@Query("select u from Users u where u.username = ?1 and u.email = ?2 and u.activeStatus = 'Y'")
	Users findActiveUser(String username , String email);
	
	@Query("select u from Users u where u.username = ?1 and u.activeStatus = 'Y'")
	Users findByUsername(String username);
	

}
