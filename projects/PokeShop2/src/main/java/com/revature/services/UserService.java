package com.revature.services;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.PokemonDAO;
import com.revature.DAO.PokemonPostgres;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserPostgres;
import com.revature.models.Pokemon;
import com.revature.models.User;

public class UserService {
//	private User u = new User();
	private UserDAO ud = new UserPostgres();
	private PokemonDAO pd = new PokemonPostgres();
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
	
//	public List<Pokemon> retrieveUserPokemon() throws SQLException, IOException{
//		return ud.retrieveUserPokemon();
//	}
	public void displayUserPokemon() throws SQLException, IOException {
		User u = new User();
		List<Pokemon> pokemon = pd.retrieveUserPokemon(u.getId());
		for(Pokemon pok : pokemon) {
				System.out.println(pok.getpId() + " : " + pok.getpName() + " : " + pok.getDescription());
		}
	}
}
