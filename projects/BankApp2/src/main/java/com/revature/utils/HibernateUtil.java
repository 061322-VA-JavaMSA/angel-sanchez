package com.revature.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		
		if (sf == null || sf.isClosed()) {
			sf = new Configuration()
					.configure("hibernate.cfg.xml")
					.buildSessionFactory();
		}
		
		return sf;
	}

}
