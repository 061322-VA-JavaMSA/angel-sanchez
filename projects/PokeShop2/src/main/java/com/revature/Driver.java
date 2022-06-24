package com.revature;

import java.util.List;


import java.util.Scanner;


// import com.revature.exceptions.LoginException;
import javax.security.auth.login.LoginException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;

public class Driver {
	
	static Scanner scan;
	static AuthService as;
	static UserService us;
	
	static String username;
	static String password;
	
	private static Logger log = LogManager.getLogger(Driver.class);

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		as = new AuthService();
		us = new UserService();
		boolean in = true;
		//		menus, will greet, then ask to login/register
		
		System.out.println("Welcome to the PokeShop! What is your name?");
		String name = scan.nextLine();
		
		System.out.println("Hello " + name + "!");
		System.out.println("What would you like to start with? \n 1: Login? \n 2: Register?");
		int input = scan.nextInt();
		
		while(in) {
			switch(input) {
			case 1:
				Login();
				System.out.println("Congratulations on becoming a Pokemon Trainer!");
				System.out.println("We have to get you started, please choose any of the following from our inventory: ");
				break;
			case 2:
				Register();
				break;
			default:
				System.out.println("Please enter a valid Integer.");
			}
			
		}
		
		
		scan.close();
	}
	
	public static void Login() {
		System.out.println("Enter your username: ");
		username = scan.nextLine();
		System.out.println("Enter your password: ");
		password = scan.nextLine();
		
		try {
			log.info(as.login(username, password));
		} catch (LoginException e) {
			log.error("Invalid credentials.");
			e.printStackTrace();
		}
		
	}
	
	public static void Register() {
		List<User> users = us.getUsers();
		for(User u : users) {
			System.out.println(u);
		}
		
		User newUser = new User();
		System.out.println("Thank you for choosing us as your PokeTutor! Register: ");
		
		System.out.println("Please enter a username for your trainer: ");
		String uname = scan.nextLine();
		
		System.out.println();
		
		System.out.println("Please enter a password for your trainer: ");
		String pass = scan.nextLine();
		
		newUser.setUsername(uname);
		newUser.setPassword(pass);
		
		log.info(us.createUser(newUser));
		
		User createdUser = us.createUser(newUser);
		System.out.println("Trainer: " + createdUser + "has been created.");
	}

}
