package com.revature.util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	/*
	 * Singleton -
	 * Design pattern that ensures that there is only one instance of a class
	 * 		Useful for heavier resources
	 * enforce via multiple conditions
	 * 		private static instance of the singleton class
	 * 		public static getter method to retrieve the same instance of the singleton
	 * 		private constructor
	 */
	// reuse c instead of creating new connections to the DB
	
	private static Connection c;
	
	public static Connection getConnectionFromFile() throws SQLException, IOException{
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		prop.load(loader.getResourceAsStream("connection.properties"));
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}
	
	public static Connection getConnectionFromEnv() throws SQLException {
		/*
		 * In windows, search for environment variables in search bar
		 * 	- set new system variables
		 *  - RESTART IDE TO RESET THE VARIABLE
		 */
		
		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USER");
		String password = System.getenv("DB_PASS");
		
		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}
		
		return c;
	}

}
