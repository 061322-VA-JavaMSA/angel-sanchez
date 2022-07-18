package com.revature.DAO;

import com.revature.Models.Role;

public interface RolesDAO {
	Role getRoleByName(String name);
	Role getRoleById(int id);
}
