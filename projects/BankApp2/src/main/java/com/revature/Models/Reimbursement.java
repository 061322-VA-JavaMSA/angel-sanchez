package com.revature.Models;

import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="reimbursement")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private int amount;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Timestamp submitted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Timestamp resolved;
	
	@Column
	private String description;
	
	@ManyToOne
	@JoinColumn(name="author", insertable = true, updatable = false)
	private User author;
	
	@ManyToOne
	@JoinColumn(name="resolver", insertable = true, updatable = false)
	private User resolver;
	
	@ManyToOne
	@JoinColumn(name="status_id", insertable = true, updatable = true)
	private R_status status_id;
	
	@ManyToOne
	@JoinColumn(name="type_id", insertable = true, updatable = false)
	private R_type t_id;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public R_status getStatus_id() {
		return status_id;
	}
	
	public void setStatus_id(R_status status_id) {
		this.status_id = status_id;
	}
	
	public R_type getT_id() {
		return t_id;
	}
	
	public void setT_id(R_type t_id) {
		this.t_id = t_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, status_id, t_id, resolved, resolver, submitted);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Reimbursement other = (Reimbursement) obj;
		
		return amount == other.amount
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id
				&& Objects.equals(status_id, other.status_id) && Objects.equals(t_id, other.t_id)
				&& Objects.equals(resolved, other.resolved) && Objects.equals(resolver, other.resolver)
				&& Objects.equals(submitted, other.submitted);
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", author=" + author + ", resolver=" + resolver + ", status="
				+ status_id + ", t_id=" + t_id + "]";
	}

	
}
