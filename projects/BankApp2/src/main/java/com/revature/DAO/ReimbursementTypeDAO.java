package com.revature.DAO;

import com.revature.Models.R_type;

public interface ReimbursementTypeDAO {
	R_type getReimbursementTypeById(int id);
	R_type getTypeByName(String type);
}
