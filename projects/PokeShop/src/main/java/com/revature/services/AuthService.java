package com.revature.services;

import javax.security.auth.login.LoginException;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserPostgres;
import com.revature.models.User;

public class AuthService {
	private UserDAO ud = new UserPostgres();
	
	public User login(String username, String password) throws LoginException{
		//if username/password passed are null, throws an exception
		if(username == null || password == null) {
			throw new LoginException();
		}
		User u = ud.retrieveUserByUsername(username);
		//if no user of that name has been retrieved/if pass don't match, throw an exception
		if(u == null || !u.getPassword().equals(password)) {
			throw new LoginException();
		}
		return u;
	}

}
