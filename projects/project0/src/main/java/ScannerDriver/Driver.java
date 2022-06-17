package ScannerDriver;
import java.util.Scanner;

import model.User;
import services.UserService;

public class Driver {
	
	static Scanner sc;
	static UserService us;

	public static void main(String[] args) {
		// Scanner, menus Login/Register
		us = new UserService();
		sc = new Scanner(System.in);
		System.out.println("Welcome to the Pokemon Shop!");
		System.out.println("Please select an option. \n 1: Login. \n 2: Register.");
		String option = sc.nextLine();
		
		switch(option) {
		case "1":
			login();
			break;
		case "2":
			register();
			break;
		default:
			System.out.println("Please put a valid input.");
		}
		
		System.out.println(us.getUserById(0)); //sets the user's id
		
		sc.close();
	}
	
	public static void login() {
		
	}
	
	public static void register() {
		User newUser = new User();
		System.out.println("Registration:");
		System.out.println("Please enter your name:");
		newUser.setName(sc.nextLine());
		System.out.println("Please enter your username:");
		newUser.setUsername(sc.nextLine());
		System.out.println("Please enter your password:");
		newUser.setPassword(sc.nextLine());
		
		User createdUser = us.createUser(newUser);
		System.out.println("User: " + createdUser + " has been created.");
	}

}
