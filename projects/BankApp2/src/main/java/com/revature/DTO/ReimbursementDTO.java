package com.revature.DTO;

import java.sql.Timestamp;

import com.revature.Models.R_status;
import com.revature.Models.R_type;
import com.revature.Models.Reimbursement;

public class ReimbursementDTO {
	private int id;
	private int amount;
	private Timestamp submitted;
 	private Timestamp resolved;
	private String description;
	private UserDTO author;
	private UserDTO resolver;	
	private R_status status;
	private R_type type;
	
	
	public ReimbursementDTO(Reimbursement r) {
 		id = r.getId();
		amount = r.getAmount();
		submitted = r.getSubmitted();
		resolved = (r.getResolved());
		author = new UserDTO();
		resolver = new UserDTO();
		status = r.getStatus_id(); //1 = Approve, 2 = Denied
		type = r.getT_id(); //1 = LODGING, 2 = TRAVEL, 3 = FOOD, 4 = OTHER
		description = r.getDescription();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}


	public UserDTO getAuthor() {
		return author;
	}

	public void setAuthor(UserDTO author) {
		this.author = author;
	}

	public UserDTO getResolver() {
		return resolver;
	}

	public void setResolver(UserDTO resolver) {
		this.resolver = resolver;
	}

	public R_status getReim_status() {
		return status;
	}

	public void setReim_status(R_status status) {
		this.status = status;
	}

	public R_type getReim_type() {
		return type;
	}

	public void setReim_type(R_type type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
