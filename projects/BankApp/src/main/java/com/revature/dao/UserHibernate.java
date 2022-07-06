package com.revature.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

//the purpose is to get rid of "boil code", repeating code like sql statements
public class UserHibernate implements UserDAO{

	@Override
	public User insertUser(User u) {
		// TODO Auto-generated method stub
		u.setId(-1);
		try(Session s = HibernateUtil.getSessionFactory().openSession()){ //session = connection, can do transactions, call methods, and create queries
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
//		try(Session s = HibernateUtil.getSessionFactory().openSession()){
//			String sql = "select * from hbn.users where id = :id;";
//			NativeQuery<User> nq = s.createNativeQuery(sql, User.class); fancier way to use a prepared statement using NativeQuery
//			nq.setParameter("id", id); //similar to set int in a prepared statement
//			user = nq.getSingleResult(); //run it by sending to DB
//		}
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			//SELECT * FROM USERS WHERE USERNAME = '' ;
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			//define the entity that is being searched
			Root<User> root = cq.from(User.class);
			
			//define conditions
			Predicate predicateForUsername = cb.equal(root.get("username"),username); //username string will equal to teh username that was passed in
//			Predicate predicateForSomethingElse = cb.equal(root.get("password"), password);
//			Predicate predicateForUnameAndPass = cb.and(predicateForUsername, predicateForSomethingElse); //queries that does usernames, and passwords
			
			cq.select(root).where(predicateForUsername);
			
			//retrieve result
			user = (User) s.createQuery(cq).getSingleResult();
		}
		return user;
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
