package com.revature.services;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserHibernate;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;

//adding services for our user, once created their info will be displayed in list format

public class UserService {
	
	private UserDAO ud = new UserHibernate();
	
	public User createUser(User u) throws UserNotCreatedException{
		//by default, any created account will be a basic user
		u.setRole(Role.BASIC_USER);
		
		User createdUser = ud.insertUser(u); //initialize the new user and insert into the list
		
		if(createdUser.getId() == -1) {
			throw  new UserNotCreatedException();
		}
		return createdUser;
	}
	
	public User getUserById(int id) throws UserNotFoundException{
		User u = ud.getUserById(id);
		if(u == null) {
			throw new UserNotFoundException();
		}
		return u;
	}
	
	public List<User> getUsers(){
		List<User> users = ud.getUsers();
		return users;
	}

}
