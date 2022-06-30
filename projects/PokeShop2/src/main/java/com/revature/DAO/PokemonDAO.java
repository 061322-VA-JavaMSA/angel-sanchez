package com.revature.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Offers;
import com.revature.models.Pokemon;
import com.revature.models.User;

public interface PokemonDAO {
	
	Pokemon createPokemon(Pokemon p) throws SQLException, IOException;
	List<Pokemon> retrievePokemon() throws SQLException, IOException;
	boolean deletePokemon(int id) throws IOException;
	List<Pokemon> retrieveUserPokemon(int id);
	
//	Pokemon makeAnOffer(Pokemon p) throws IOException;
//	Offers makeAnOffer(Offers o) throws SQLException, IOException;

}
