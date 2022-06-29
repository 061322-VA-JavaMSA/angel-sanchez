package com.revature.views;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.DAO.PokemonDAO;
import com.revature.DAO.PokemonPostgres;
import com.revature.models.Pokemon;
import com.revature.models.User;
import com.revature.services.PokemonService;
import com.revature.services.UserService;

public class UserView {
	//we need our customer to view what pokemon they own
	
	UserService us = new UserService();
	Pokemon p = new Pokemon();
	PokemonService ps = new PokemonService();
	PokemonDAO pd = new PokemonPostgres();
	
	public void UserInput(User u) throws SQLException, IOException {
		System.out.println("Welcome " + u.getUsername() + " to your Pokedex!");
		displayUserPokemon(u);
	}
	
//	public void UserInventory(User u) throws SQLException, IOException {
//		Pokemon p = new Pokemon();
//		displayUserPokemon(p);
//	}
	public List<Pokemon> displayUserPokemon(User id) throws SQLException, IOException {
		List<Pokemon> Pokemon = ps.getPokemon();
		for(int i = 0; i < Pokemon.size(); i++) {
				System.out.println((i+1) + ":" + ps.getPokemon().get(i).getpName());
			}
		return Pokemon;
		}
	}
