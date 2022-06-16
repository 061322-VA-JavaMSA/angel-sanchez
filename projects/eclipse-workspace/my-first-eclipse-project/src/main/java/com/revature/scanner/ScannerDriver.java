package com.revature.scanner;
import java.util.Scanner;

// by default, everything in the java.lang package is imported
public class ScannerDriver {
	static Scanner scan = new Scanner(System.in); //scan is now static

	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("Hello World!");
//		System.out.println("What is your name?");
//		String name = scan.nextLine();
//		
//		System.out.println("Hello " +  name + "!");
//		System.out.println("Please enter a number: ");
//		
//		//int num = scan.nextInt(); 
//		//scan.nextLine();//flush leftover from the previous input capture
//		
//		String number1 = scan.nextLine();
//		//validation
//		int num = Integer.parseInt(number1);
//		
//		System.out.println("Your number is " + num);
//		System.out.println("Please pick a number from 1-2:");
//		String number1 = scan.nextLine();
//		
//		switch(number) {
//		case "1":
//			System.out.println("Hello");
//			break;
//		case "2":
//			System.out.println("Goodbye");
//			break;
//		default:
//			System.out.println("Not recognized");
//		}
		loginScreen();
		menu();
		scan.close();
	}

	/*
	 * A user is going to input a user name and a password, if they match the hard coded values return "welcome", otherwise "invalid credentials"
	 */
	public static void loginScreen() {
		String username = "admin";
		String password = "pass";
		
		System.out.println("Please enter username");
		String usernameInput = scan.nextLine();
		System.out.println("Please enter your password");
		String passwordInput = scan.nextLine();
		
		if(username.equals(usernameInput) && (password.equals(passwordInput))) {
			System.out.println("Welcome");
		} else {
			System.out.println("Invalid credentials");
		}
	}
	public static void menu() {
		/*
		 * Menu that gives a user multiple options:
		 * 1: get a random number
		 * 2: reverse a string of the user's choice
		 * 3: exit the program
		 * 
		 * this menu should repeat until the user decides to exit
		 */
		
		//Scanner menu = new Scanner(System.in);
		boolean on = true; //set a boolean to determine when to close the program/while loop
		
		//String x = "";
		
		
		while(on) { //while the program is true:
			System.out.println("Please enter a number between 1-3. \n3 will exit you out.");
			String x = scan.nextLine(); //use scanner method to take the user input
		switch(x) { //start a switch case to determine the logic behind the user's input
		case "1": //if the user enters 1:
			System.out.println("You have entered: " + x);
			System.out.println("Your lucky number is: " + (int)(Math.random()*1000));
			System.out.println();
			break; //always break in between cases so the program knows when to reiterate
		case "2": //if the user enters 2:
			String reverse;
			System.out.println("You have entered: " + x);
			System.out.println("Enter your favorite line from a movie: ");
			reverse = scan.nextLine(); //take in the user's sentence
			StringBuilder sb = new StringBuilder(reverse); //either stringBuilder or Buffer would suffice in order to instantiate the user's line
			System.out.println(reverse + " | Your favorite line but in reverse: " + sb.reverse()); //reverse the user's sentence with the reverse() method
			System.out.println();
			break; //break the 2nd case
		case "3": //if the user enters 3:
			on = false; //at this point the program will exit when the user enters "3"
			System.out.println("Until next time!");
			System.out.println();
			break; //final break point of the user's choice
		default: //we include a default in case the user doesn't pick the correct number or enters an invalid input
			System.out.println("Invalid Input! Please pick a number between 1-3.");
			System.out.println();
		}
		}
		
	}

}
