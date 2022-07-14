package com.revature.DAO;

import java.io.IOException;
import java.util.List;

import com.revature.Models.R_status;
import com.revature.Models.Reimbursement;
import com.revature.Models.User;

public interface ReimbursementDAO {
	Reimbursement insertReimbursement(Reimbursement r);
	
	boolean updateReimbursement(Reimbursement r) throws IOException;
	
	List<Reimbursement> getReimbursement();
	
	List<Reimbursement> getReimbursementByResolverId(int id);
	
	List<Reimbursement> getReimbursementByStatus(Reimbursement rs);
	
	List<Reimbursement> getReimbursementByAuthor(User u);

	Object setStatusById(int userID, User approverUser, R_status rs);

}
