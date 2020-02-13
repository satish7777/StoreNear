package com.meda.user.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meda.user.userservice.entities.User;
import com.meda.user.userservice.exception.UserNotFoundException;
import com.meda.user.userservice.exception.UserServiceException;
import com.meda.user.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path="/GetAllUsers",method=RequestMethod.GET)
	public List<User> getAllUsers()  throws UserNotFoundException,UserServiceException
	{
		
		return userService.findAllUsers();
	}

	@GetMapping(path="/getUser/{userName}")
	public User getUser(@PathVariable("userName") final String userName)  throws UserNotFoundException,UserServiceException
	{
		
		return userService.getUserByUserName(userName);
	}

	@RequestMapping(path="/AddUser",method=RequestMethod.POST)
	public User createUser(@RequestBody User user)  throws UserServiceException,Exception
	{
		
		return userService.createUser(user);
	}

	@RequestMapping(path="/UpdateUser/{userName}",method=RequestMethod.POST)
	public User updateUser(@RequestBody User user,@PathVariable("userName") final String userName) throws UserNotFoundException,UserServiceException
	{ 
		
		return userService.updateUserByUserName(user,userName);
	}
	
	@PutMapping(path="/deleteUser/{userName}")
	public List<User> deleteUser(@PathVariable("userName") final String userName)  throws UserNotFoundException,UserServiceException
	{
		
		return userService.deleteUser(userName);
	}
	
	
	
	@GetMapping(path="/Auth/{username}/{password}")
	public User authenticateUser(@PathVariable("userName") final String userName,@PathVariable("password") final String password) throws UserNotFoundException,UserServiceException
	{
		
		return userService.authenticateUser(userName, password);
    }
	
}
