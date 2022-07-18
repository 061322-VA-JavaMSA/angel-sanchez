package com.revature.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserHibernate;
import com.revature.Exceptions.UserNotCreatedException;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.Role;
import com.revature.Models.User;

public class UserService {
private UserDAO ud = new UserHibernate();
private static Logger log = LogManager.getLogger(UserService.class);
	
	public User createUser(User u){
		//by default, any created account will be a basic user
//		u.setRole(null);
		
		User createdUser = ud.insertUser(u); //initialize the new user and insert into the list
		
		return createdUser;
	}
	
	public User getUserById(int id) throws UserNotFoundException{
		User u = ud.getUserById(id);
		if(u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}
	
	public List<User> getUsers() throws UserNotFoundException{
		List<User> users = ud.getUsers();
		if(users == null || users.isEmpty()) {
			throw new UserNotFoundException();
		}
		log.info("Users: " + users.size() + " users.");
		return users;
	}
	
	public List<User> getUserByRole(Role r) throws UserNotFoundException{
		List<User> users = null;
		if(r == null) {
			throw new UserNotFoundException();
		}
		users = ud.getUserByRole(r);
		if(users == null || users.isEmpty()) {
			throw new UserNotFoundException();
		}
		log.info("User: " + users.size() + " users.");
		return users;
	}
	
	
}
