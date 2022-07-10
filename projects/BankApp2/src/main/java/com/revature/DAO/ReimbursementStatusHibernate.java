package com.revature.DAO;

import org.hibernate.Session;

import com.revature.Models.R_status;
import com.revature.utils.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDAO{

	@Override
	public R_status getReimbursementStatusById(int id) {
		// TODO Auto-generated method stub
		R_status status = null;

		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			status = s.get(R_status.class, id);
		}
		return status;
		
	}
	

}
