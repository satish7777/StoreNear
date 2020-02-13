package com.meda.user.userservice.respository;

import org.springframework.stereotype.Repository;

import com.meda.user.userservice.entities.User;
import com.meda.user.userservice.exception.UserNotFoundException;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserName(String userName) throws UserNotFoundException;
	
	

}
