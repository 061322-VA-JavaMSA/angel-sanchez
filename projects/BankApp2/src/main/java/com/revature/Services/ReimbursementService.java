package com.revature.Services;

import java.io.IOException;

import java.util.List;

import com.revature.DAO.ReimbursementDAO;
import com.revature.DAO.ReimbursementHibernate;
import com.revature.Models.Reimbursement;
import com.revature.Models.User;

public class ReimbursementService {
	private ReimbursementDAO rd = new ReimbursementHibernate();
	
	public List<Reimbursement> getReimbursements() {
		return rd.getReimbursement();
	}
	
	public List<Reimbursement> getReimbursementsByResolverId(int id) {
		List<Reimbursement> reims = rd.getReimbursementByResolverId(id);
		return reims;
	}
	
	public List<Reimbursement> getReimbursementByAuthor(User u){
		List<Reimbursement> reimb = rd.getReimbursementByAuthor(u);
		return reimb;
	}
	
	public Reimbursement insertReimbursement(Reimbursement r) {
		Reimbursement cr = rd.insertReimbursement(r);
		return cr;
	}
	
	public boolean updateReimbursement(Reimbursement r) throws IOException {
		boolean a = rd.updateReimbursement(r);
		return a;
	}

	public boolean setStatusById(int userID, int approverID, String string) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getByID(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}