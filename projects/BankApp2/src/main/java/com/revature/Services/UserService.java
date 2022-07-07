package com.revature.Services;

import java.util.List;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserHibernate;
import com.revature.Exceptions.UserNotCreatedException;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.User;

public class UserService {
private UserDAO ud = new UserHibernate();
	
	public User createUser(User u) throws UserNotCreatedException{
		//by default, any created account will be a basic user
		u.setRole(null);
		
		User createdUser = ud.insertUser(u); //initialize the new user and insert into the list
		
		if(createdUser.getId() == -1) {
			throw new UserNotCreatedException();
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
		return ud.getUsers();
	}

}
