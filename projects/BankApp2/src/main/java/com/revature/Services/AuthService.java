package com.revature.Services;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserHibernate;
import com.revature.Exceptions.LoginException;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.User;

public class AuthService {
private UserDAO ud = new UserHibernate();
	
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
