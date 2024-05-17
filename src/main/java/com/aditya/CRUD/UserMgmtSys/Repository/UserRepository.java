package com.aditya.CRUD.UserMgmtSys.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.CRUD.UserMgmtSys.Users.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	
	public User findByFirstname(String firstname);
	
}
