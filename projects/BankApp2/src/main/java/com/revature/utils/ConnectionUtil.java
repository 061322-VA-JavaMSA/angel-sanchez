package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionUtil {
	private static Connection c;

	public static Connection getConnectionFromEnv() throws SQLException {
		try {
			Class.forName("org.postgressql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = System.getenv("DB_URL");
		String username = System.getenv("DB_USERNAME");
		String password = System.getenv("DB_PASSWORD");

		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}

		return c;
	}

}
