package com.revature.Models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="reimbursement_type")
public class R_type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="reim_type")
	private String reim_type;
	
	
	
	public R_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the reim_type
	 */
	public String getReim_type() {
		return reim_type;
	}
	/**
	 * @param reim_type the reim_type to set
	 */
	public void setReim_type(String reim_type) {
		this.reim_type = reim_type;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, reim_type);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		R_type other = (R_type) obj;
		
		return id == other.id && Objects.equals(reim_type, other.reim_type);
	}
	@Override
	public String toString() {
		return "R_type [id=" + id + ", reim_type=" + reim_type + "]";
	}
	
	
}
