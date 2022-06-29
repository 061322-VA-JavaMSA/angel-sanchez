package com.revature.services;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserPostgres;
import com.revature.models.User;

public class UserService {
	private UserDAO ud = new UserPostgres();
	private static Logger log = LogManager.getLogger(UserService.class);
	
	public List<User> getUsers() throws IOException{
		return ud.retrieveUsers();
	}
	
	public User createUser(User u) throws IOException{
		//logic to validate u
		//if ok
		//u = ud.createUser(u);
		User user = ud.createUser(u);
		log.info("User: " + user + "has been created.");
		return user;
	}
	
	public User retrieveById(int id) throws IOException{
		User u = ud.retrieveUserById(id);
		System.out.println("User id: " + u);
		return u;
		}
}
