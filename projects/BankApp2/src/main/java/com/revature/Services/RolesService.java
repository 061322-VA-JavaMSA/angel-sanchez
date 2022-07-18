package com.revature.Services;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.DAO.RolesDAO;
import com.revature.DAO.RolesHibernate;
import com.revature.Exceptions.UserNotFoundException;
import com.revature.Models.Role;

public class RolesService {
	private RolesDAO rd = new RolesHibernate();
	private static Logger log = LogManager.getLogger(RolesService.class);
	
	public Role getRole(String name) throws UserNotFoundException{
		Role r = rd.getRoleByName(name);
		if(r == null) {
			throw new UserNotFoundException();
		}
		log.info("Role: ", r);
		return r;
	}
	
	public Role getRole(int id) throws UserNotFoundException{
		Role r = rd.getRoleById(id);
		if(r == null) {
			throw new UserNotFoundException();
		}
		log.info("Role id: ", r);
		return r;
	}

}
