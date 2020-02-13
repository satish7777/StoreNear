package com.meda.user.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meda.user.userservice.entities.User;
import com.meda.user.userservice.exception.UserNotFoundException;
import com.meda.user.userservice.exception.UserServiceException;
import com.meda.user.userservice.respository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	public User createUser(User user)  throws UserServiceException,Exception
	{
		try {
			User userCheck  = getUserByUserName(user.getUserName());
			
			if(userCheck!=null) {
				 throw new UserServiceException("User Already Exists ");
				
			}else {
			
		userRepository.save(user);
		return userRepository.getOne(user.getUserId());
			}
		}catch(UserServiceException e) {
			
			throw e;
			
		}
		catch(Exception e) {
			
			throw new Exception("Exception occured while creating the user" ,e);
			
		}
	 }


	public User authenticateUser(String userName, String password) throws UserNotFoundException,UserServiceException {
		try {
		User user  = getUserByUserName(userName);
	
		if(user!=null) {
			if(userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword()) ) {
			
			return user;
		  }else {
			throw new UserServiceException("Enter the Correct Password");
		  }
		}
		 throw new UserNotFoundException("User Not Found Exception");
		} catch(UserNotFoundException e) {
			//e.printStackTrace();
			throw e;
		}catch (UserServiceException e){
			throw e;
		}
		catch (Exception e){
			throw new UserServiceException("Error Occured while Authentication:" ,e);
		}
	}




	public List<User> findAllUsers()  throws UserServiceException
	{ 
		try {
		return userRepository.findAll();
	  }catch(Exception e) {
		
		throw new UserServiceException("Exception occured while fetching the Users" ,e);
		
	}
	}



	public User getUserByUserName(String userName)  throws UserNotFoundException,UserServiceException
	 {
		try {
		return userRepository.findByUserName(userName);
	 }catch(UserNotFoundException e) {
			
			throw new UserNotFoundException("User Doesn't Exists" ,e);
			
		}catch(Exception use) {
			throw new UserServiceException("Exception occured while fetching the User" ,use);
		}
	}


	public User updateUserByUserName(User user, String userName)  throws UserNotFoundException,UserServiceException
	{
		try {
		User update = getUserByUserName(userName);
		
		if(update!=null) {
		update.setLocation(user.getLocation());
		update.setPassword(user.getPassword());
		update.setStatus(user.getStatus());
		update.setRoles(user.getRole());
		
		userRepository.save(update);
		return getUserByUserName(userName);
		}else {
			throw new UserNotFoundException("User Doesn't exists");
		}
	}catch(UserNotFoundException e) {
		//e.printStackTrace();
		
		throw e;
	}catch(Exception e) {
		throw new UserServiceException("Exception occured while updating the User::"+e.getMessage() );
	}
	}



	public List<User> deleteUser(String userName)  throws UserNotFoundException,UserServiceException
	 {
		try {
		User user = getUserByUserName(userName);
		if(user!=null) {
		userRepository.delete(user);
		return findAllUsers();
		
	 }else {
			throw new UserNotFoundException("User Doesn't exists");
		}
	}catch(UserNotFoundException e) {
		//e.printStackTrace();
		throw e;
	}catch(UserServiceException e) {
		
		throw new UserServiceException("Exception occured while deleting the User" ,e);
		
	}catch(Exception e) {
		
		throw new UserServiceException("Exception occured while deleting the User"+e.getMessage());
		
	}
		
	}

}
