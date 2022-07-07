package com.revature.DAO;

import java.util.List;

import com.revature.Models.Reimbursement;

public interface ReimbursementDAO {
	Reimbursement insertReimbursement(Reimbursement r);
	
	List<Reimbursement> getReimbursement();
	
	List<Reimbursement> getReimbursementByResolverId(int id);
	
	Reimbursement updateReimbursement(Reimbursement r);
	
	List<Reimbursement> getReimbursementByStatus(Reimbursement rs);

}
