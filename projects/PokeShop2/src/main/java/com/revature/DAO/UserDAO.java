package com.revature.DAO;
import java.util.List;

import com.revature.models.User;
import java.io.IOException;

public interface UserDAO {
	User createUser(User u) throws IOException;
	User retrieveUserByUsername(String username) throws IOException;
	User retrieveUserById(int id) throws IOException;

}
