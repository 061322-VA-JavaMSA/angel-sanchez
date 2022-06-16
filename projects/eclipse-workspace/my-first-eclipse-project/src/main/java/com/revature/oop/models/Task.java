package com.revature.oop.models;
import java.time.LocalDate; //for the date variable

public class Task {
	
	public String description;
	public boolean completed;
	public LocalDate dueDate;

	public Task() {
		dueDate = LocalDate.now().plusDays(5); //due in 5 days
		description = "None provided";
	}
	public Task(String description) {
		this(); //will assign due date then description after, constructor chaining, 
		//invokes the no-args constructor before executing this constructor's logic
		this.description = description;
		
	}
}
