package com.revature.Services;

import com.revature.DAO.ReimbursementTypeDAO;

import com.revature.DAO.ReimbursementTypeHibernate;
import com.revature.Exceptions.RNotFoundException;
import com.revature.Models.R_type;

public class RTypeService {
	private ReimbursementTypeDAO rtd = new ReimbursementTypeHibernate();
	
	public R_type getType(int id) throws RNotFoundException {
		R_type rt = rtd.getReimbursementTypeById(id);
		if(rt == null) {
			throw new RNotFoundException();
		}
		return rt;
	}
	public R_type getTypeByName(String type) throws RNotFoundException{
		R_type rt = rtd.getTypeByName(type);
		if(rt == null) {
			throw new RNotFoundException();
		}
		return rt;
	}
}