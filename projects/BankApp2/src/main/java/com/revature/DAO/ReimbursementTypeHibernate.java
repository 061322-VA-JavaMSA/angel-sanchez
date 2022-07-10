package com.revature.DAO;

import org.hibernate.Session;

import com.revature.Models.R_type;
import com.revature.utils.HibernateUtil;

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

}
