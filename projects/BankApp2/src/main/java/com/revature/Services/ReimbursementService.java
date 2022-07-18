package com.revature.Services;

import java.io.IOException;

import java.util.List;

import com.revature.DAO.ReimbursementDAO;
import com.revature.DAO.ReimbursementHibernate;
import com.revature.DAO.ReimbursementStatusDAO;
import com.revature.DAO.ReimbursementStatusHibernate;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserHibernate;
import com.revature.Exceptions.RNotUpdatedException;
import com.revature.Models.R_status;
import com.revature.Models.Reimbursement;
import com.revature.Models.User;

public class ReimbursementService {
	private ReimbursementDAO rd = new ReimbursementHibernate();
	private ReimbursementStatusDAO rsd = new ReimbursementStatusHibernate();
	private UserDAO ud = new UserHibernate();
	
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
	
	public Reimbursement updateReimbursement(Reimbursement r) throws IOException {
		return r;
	}

	public boolean setStatusById(int userID, int approverID, String status) throws RNotUpdatedException {
		// TODO Auto-generated method stub
		R_status rs = rsd.getReimbursementStatusById(approverID);
		User u = ud.getUserById(approverID);
		boolean update = (boolean) rd.setStatusById(userID, u, rs);
		if(update == false) {
			throw new RNotUpdatedException();
		}
		return update;
	}

	public Object getByID(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}