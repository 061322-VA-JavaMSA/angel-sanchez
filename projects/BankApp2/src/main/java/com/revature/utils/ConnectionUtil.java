package com.revature.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionUtil {
	private static Connection c;

	public static Connection getConnectionFromEnv() throws SQLException, IOException {
		try {
			Class.forName("org.postgressql.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = System.getenv("DB_url");
		String username = System.getenv("DB_username");
		String password = System.getenv("DB_password");

		if (c == null || c.isClosed()) {
			c = DriverManager.getConnection(url, username, password);
		}

		return c;
	}

}
