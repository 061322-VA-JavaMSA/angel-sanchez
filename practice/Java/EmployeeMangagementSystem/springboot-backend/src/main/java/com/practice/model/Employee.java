package com.practice.model;

import lombok.Data;
import javax.persistence.*;

// per LOMBOK, this annotation creates getters/setters
@Data
@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

}
