package com.revature;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;


import java.util.Scanner;


// import com.revature.exceptions.LoginException;
import javax.security.auth.login.LoginException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.PokemonDAO;
import com.revature.DAO.PokemonPostgres;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserPostgres;
import com.revature.models.Offers;
import com.revature.models.Pokemon;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.PokeOfferService;
import com.revature.services.PokemonService;
import com.revature.services.UserService;

public class Driver {
	
	static Scanner scan;
	static AuthService as;
	static UserService us;
	static PokemonService ps;
	static PokeOfferService pos;
	static User id;
	
	static String username = null;
	static String password = null;
	
	static int userId;
	
	private static Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) throws SQLException, IOException {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		ps = new PokemonService();
		pos = new PokeOfferService();
		
		//		menus, will greet, then ask to login/register
		
		System.out.println("Welcome to the PokeShop! What is your name?");
		String name = scan.nextLine();
		
		System.out.println("Hello " + name + "!");
		System.out.println("What would you like to start with? \n 1: Login? \n 2: Register?");
		int input = scan.nextInt();
		
			switch(input) {
			case 1:
				System.out.println("Congratulations on becoming a Pokemon Trainer!");
				System.out.println("Please enter your username: ");
				username = scan.next();
				
				System.out.println();
				
				System.out.println("Please enter your password: ");
				password = scan.next();
				

				break;
			case 2:
				System.out.println("Let's get you started. Please enter a username for your trainer: ");
				String uname = scan.next();
				System.out.println("Now enter a password for security: ");
				String pass = scan.next();
				System.out.println("Will you be managing? T or F?");
				boolean in = scan.hasNextBoolean();
				
				User newUser = new User();
				newUser.setUsername(uname);
				newUser.setPassword(pass);
				newUser.setAdmin(in);
				
				System.out.println((us).createUser(newUser));
				username = uname;
				password = pass;
				
				Register(uname, pass);
				break;
			default:
				System.out.println("Please enter a valid Integer.");
			}
			
			Login(username, password);

		
		scan.close();
	}
	
	public static void Login(String username, String password) throws SQLException, IOException{
		try {
			log.info(as.login(username, password));
		} catch (LoginException e) {
			log.error("Invalid credentials.");
			System.exit(0);
			e.printStackTrace();
		}
		
		userId = as.checkId(username);
		if(as.checkAdmin(username) == false) {
			menu();
		} else {
			adminMenu();
		}
		
	}
	
	private static void adminMenu() throws SQLException, IOException{
		// TODO Auto-generated method stub
		
		System.out.println("Running as Manager.");
		System.out.println("Enter 1 to remove a pokemon. \n Enter 2 to add a pokemon. \n Enter 3 to see all offers.");
		
		switch(scan.nextInt()) {
		case 1:
			deletePokemon();
			adminMenu();
			break;
		case 2:
			createPokemon(null);
			adminMenu();
			break;
		case 3:
			checkOffers();
		default:
			System.out.println("A decision has been made!");
			adminMenu();
			break;
		};
		
	}

	private static void checkOffers() throws SQLException, IOException{
		// TODO Auto-generated method stub
		
		int offerID;
		String status;
//		boolean one;
		
		List<Offers> Offers = pos.getOffers();
		for(Offers o : Offers) {
			System.out.println(o);
		}
		
		System.out.println("Enter the ID for the offer you are concluding.");
		offerID = scan.nextInt();
		System.out.println("Enter the status for the offer: Approve or Deny. Otherwise, will default to pending.");
		status = scan.next();
		
//		if(status == "Approve") {
//			one = true;
//		}if(status == "Deny") {
//			one = false;
//		}else {
//			System.out.println("Offer will now leave as pending.");
//		}
		Offers of = new Offers();
		of.setOfferId(offerID);
		of.setStatus(status);
		pos.ChangeOfferStatus(of);
		
	}

	private static void deletePokemon(){
		// TODO Auto-generated method stub
		
		try {
			listPokemon();
			System.out.println("Type the Pokemon's id to delete.");
			ps.deletePokemon(scan.nextInt());
		} catch(SQLException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Pokemon has been deleted.");
		
	}

	private static void createPokemon(Pokemon p) throws SQLException, IOException{
		// TODO Auto-generated method stub
		String PokeName;
		int price;
		String description;
		
		System.out.println("Enter the name of the Pokemon to add: ");
		PokeName = scan.next();
		System.out.println("Enter the price of the new Pokemon as an Integer: ");
		price = scan.nextInt();
		System.out.println("Enter the any info on the pokemon: ");
		description = scan.next();
		
		Pokemon createPokemon = new Pokemon();
		
		
		createPokemon.setpName(PokeName);
		createPokemon.setPrice(price);
		createPokemon.setDescription(description);
		
		System.out.println(ps.createPokemon(createPokemon));
		System.out.println("Congratulations on adding " + PokeName + "!");
		
	}

	private static void menu() throws SQLException, IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to the beginning of your Pokemon journey!");
		System.out.println("Please enter any of the following numbers: ");
		System.out.println("1: View OUR Inventory!");
		System.out.println("2: Create an Offer: ");
		System.out.println("3: View YOUR Inventory!: ");
		
//		listPokemon();
		
		switch(scan.nextInt()) {
		case 1:
			listPokemon();
			menu();
			break;
		case 2:
			makeOffer();
			break;
		case 3:
			UserInventory(userId);
			break;
		default:
			menu();
			break;
		}
		
		
	}

	private static void UserInventory(int id) throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		us.displayUserPokemon();
		
	}

	private static void makeOffer() throws SQLException, IOException{
		// TODO Auto-generated method stub
		
		int PokemonId;
		int amount;
		int userId;
		
		Offers o = new Offers();
		
		listPokemon();
		System.out.println("Enter the pokemon's id you would like to purchase.");
		PokemonId = scan.nextInt();
		System.out.println("Enter the offer you would like to make.");
		amount = scan.nextInt();
		System.out.println("Finally, enter your user id for our system organization.");
		userId = scan.nextInt();
		
		o.setpId(PokemonId);
		o.setAmount(amount);
		o.setUserId(userId);
		pos.makeAnOffer(o);
		
		System.out.println("Offer created. Please wait by the end of the week for a response.");
		
	}

//	private static void payment() throws SQLException, IOException{
//		// TODO Auto-generated method stub
//		
//	}

	private static void listPokemon() throws SQLException, IOException {
		// TODO Auto-generated method stub
		
		List<Pokemon> pokemon = ps.getPokemon();
		for(Pokemon p : pokemon) {
			System.out.println(p);
		}
		
	}

	public static void Register(String username, String password) throws IOException {
		
		List<User> users = us.getUsers();
		for(User u : users) {
			System.out.println(u);
		}
		
		
//		System.out.println("Thank you for choosing us as your PokeTutor! Register: ");
//		
//		System.out.println("Please enter a username for your trainer: ");
//		String uname = scan.nextLine();
//		
//		System.out.println();
//		
//		System.out.println("Please enter a password for your trainer: ");
//		String pass = scan.nextLine();
//		
//		
//		
//		log.info(us.createUser(newUser));
//		
//		User createdUser = us.createUser(newUser);
//		System.out.println("Trainer: " + createdUser + "has been created.");
	}

}
