package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

//the purpose is to get rid of "boil code", repeating code like sql statements
public class UserHibernate implements UserDAO{

	@Override
	public User insertUser(User u) {
		// TODO Auto-generated method stub
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			int id = (int) s.save(u);
			u.setId(id);
			tx.commit();
		} catch(ConstraintViolationException e) {
			//use log to log it
		}
		return u;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		
		User user = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			user = s.get(User.class, id);
		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		
		List<User> users = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			users = s.createQuery("from User", User.class).list();
		}
		
		return users;
	}

}
