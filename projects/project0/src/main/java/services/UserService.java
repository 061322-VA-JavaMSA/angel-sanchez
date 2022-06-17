package services;

import dao.UserArrayList;
import dao.UserDAO;
import model.User;

public class UserService {
	
	private UserDAO createUser(User u) {
		private UserDAO ud = new UserArrayList();
		//need more verify logic to object u 
		//business logic like offers, payments, confirms, denies will go in here
		
		return ud.insertUser(u);
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return ud.getById(id);
	}

}
