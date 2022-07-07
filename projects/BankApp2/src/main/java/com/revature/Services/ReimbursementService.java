package com.revature.Services;

import java.util.List;

import com.revature.DAO.ReimbursementDAO;
import com.revature.DAO.ReimbursementHibernate;
import com.revature.Models.Reimbursement;

public class ReimbursementService {
	private ReimbursementDAO rd = new ReimbursementHibernate();
	
	public List<Reimbursement> getReimbursements() {
		return rd.getReimbursement();
	}
	
	public List<Reimbursement> getReimbursementsByResolverId(int id) {
		return rd.getReimbursementByResolverId(id);
	}

}