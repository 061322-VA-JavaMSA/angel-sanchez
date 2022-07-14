package com.revature.Models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_roles")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int role_id;
	
	@Column(name="u_role")
	private String role;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(role_id, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Role other = (Role) obj;
		return role_id == other.role_id && Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role=" + role + "]";
	}

	
	
}
