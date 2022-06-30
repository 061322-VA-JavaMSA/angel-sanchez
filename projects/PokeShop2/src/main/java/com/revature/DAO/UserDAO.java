package com.revature.DAO;
import java.util.List;

import com.revature.models.Pokemon;
import com.revature.models.User;
import java.io.IOException;
import java.sql.SQLException;

public interface UserDAO {
	User createUser(User u) throws IOException;
	User retrieveUserByUsername(String username) throws IOException;
	User retrieveUserById(int id) throws IOException;
	List<User> retrieveUsers() throws IOException;
//	List<Pokemon> retrieveUserPokemon() throws SQLException, IOException;

}
