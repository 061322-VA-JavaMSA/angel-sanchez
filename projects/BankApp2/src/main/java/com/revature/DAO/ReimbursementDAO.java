package com.revature.DAO;

import java.util.List;

import com.revature.Models.Reimbursement;
import com.revature.Models.User;

public interface ReimbursementDAO {
	Reimbursement insertReimbursement(Reimbursement r);
	
	List<Reimbursement> getReimbursement();
	
	List<Reimbursement> getReimbursementByResolverId(int id);
	
	Reimbursement updateReimbursement(Reimbursement r);
	
	List<Reimbursement> getReimbursementByStatus(Reimbursement rs);
	
	List<Reimbursement> getReimbursementByAuthor(User u);

}
