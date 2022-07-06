package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserPostgres;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class AuthService {
	private UserDAO ud = new UserPostgres();
	
	//if user is found by username and password matches, return that user
	public User login(String username, String password) throws UserNotFoundException, LoginException{
		//principal refers to the currently logged in user
		User principal = ud.getUserByUsername(username);
		
		if(principal == null) {
			throw new UserNotFoundException(); //no user was found if the current user isn't logged in
		}
		
		if(!principal.getPassword().equals(password)) {
			throw new LoginException(); //login error thrown if the password doesn't match the current user
		}
		return principal;
	}

}
