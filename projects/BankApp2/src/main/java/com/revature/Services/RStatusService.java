package com.revature.Services;

import com.revature.DAO.ReimbursementStatusDAO;

import com.revature.DAO.ReimbursementStatusHibernate;
import com.revature.Exceptions.RNotFoundException;
import com.revature.Models.R_status;

public class RStatusService {
	private ReimbursementStatusDAO rsd = new ReimbursementStatusHibernate();
	
	public R_status getStatus(int id) throws RNotFoundException {
		R_status rs = rsd.getReimbursementStatusById(id);
		if(rs == null) {
			throw new RNotFoundException();
		}
		return rs;
	}

}
