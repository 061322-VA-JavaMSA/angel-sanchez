package com.revature.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.revature.DAO.PokemonDAO;
import com.revature.DAO.PokemonPostgres;
import com.revature.models.Pokemon;

public class PokemonService {
	private PokemonDAO pd = new PokemonPostgres();
	
	public List<Pokemon> getPokemon() throws SQLException, IOException{
		return pd.retrievePokemon();
	}
	
	public Pokemon createPokemon(Pokemon p) throws IOException{
		return pd.createPokemon(p);
	}
	
	public boolean deletePokemon(int p) throws IOException{
		return pd.deletePokemon(p);
	}
	
	public Pokemon makeOffer(Pokemon p) throws IOException{
		return pd.makeAnOffer(p);
	}

}
