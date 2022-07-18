package com.revature.DAO;

import org.hibernate.Session;

import com.revature.Models.Role;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class RolesHibernate implements RolesDAO{

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		Role r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Role> cq = cb.createQuery(Role.class);
			Root<Role> root = cq.from(Role.class);
			Predicate pValue = cb.equal(root.get("role"), name);
			cq.select(root).where(pValue);
			r = (Role) s.createQuery(cq).getSingleResult();
		}
		return r;
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		Role r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			r = s.get(Role.class, id);
		}
		return r;		
	}

}
