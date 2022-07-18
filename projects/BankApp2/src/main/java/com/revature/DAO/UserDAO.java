package com.revature.DAO;

import java.util.List;

import com.revature.Models.Role;
import com.revature.Models.User;

public interface UserDAO {
	User insertUser(User u);
	User getUserById(int id);
	User getUserByUsername(String username);
	boolean updateUser(User u);
	List<User> getUsers();
	List<User> getUserByRole(Role r);

}