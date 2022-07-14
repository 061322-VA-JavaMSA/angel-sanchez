package com.revature.DAO;

import org.hibernate.Session;

import com.revature.Models.R_type;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementTypeHibernate implements ReimbursementTypeDAO{

	@Override
	public R_type getReimbursementTypeById(int id) {
		// TODO Auto-generated method stub
		R_type type = null;
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			type = s.get(R_type.class, id);
		}
		return type;
	}

	@Override
	public R_type getTypeByName(String type) {
		// TODO Auto-generated method stub
		R_type rt = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<R_type> cqr = cb.createQuery(R_type.class);
			Root<R_type> root = cqr.from(R_type.class);
			
			Predicate pValue = cb.equal(root.get("type"), type);
			cqr.select(root).where(pValue);
			rt = (R_type) s.createQuery(cqr).getSingleResult();
		}
		return rt;
	}

}
