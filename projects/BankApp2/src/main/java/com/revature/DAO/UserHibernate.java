package com.revature.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.Models.User;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class UserHibernate implements UserDAO{

	@SuppressWarnings("deprecation")
	@Override
	public User insertUser(User u) {
		// TODO Auto-generated method stub
//		u.setId(-1);
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
		User u = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			u = s.get(User.class, id);
		}

		return u;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		User u = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> root = cq.from(User.class);
			
			Predicate pUname = cb.equal(root.get("username"), username);
			cq.select(root).where(pUname);
			
			u = (User) s.createQuery(cq).getSingleResult();
		}

		return u;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> users = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			users = s.createQuery("from User", User.class).list();
		}

		return users;
	}

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public boolean updateUser(User u) {
		int rowsChanged = -1;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction trans = s.beginTransaction();

			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaUpdate<User> cu = cb.createCriteriaUpdate(User.class);
			Root<User> root  = cu.from(User.class);
			String passwordString = u.getPassword();
			
			cu.set(root.get("first_name"), u.getFirstName());
			cu.set(root.get("last_name"), u.getLastName());
			cu.set(root.get("email"), u.getEmail());
			
			if(passwordString != null && !passwordString.isEmpty()) {
				cu.set(root.get("password"), passwordString);
			}
			cu.where(cb.equal(root.get("id"),u.getId()));
 			rowsChanged =s.createQuery(cu).executeUpdate();
			if (rowsChanged < 1) {
				return false;
			}
		}
		return true;
	}

}
