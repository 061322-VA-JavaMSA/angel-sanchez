package com.revature.oop.models;
import java.time.LocalDate; //for the date variable
import java.util.Objects;

public class Task {
	
	private int id;
	private String description;
	private boolean completed;
	private LocalDate dueDate;
	private User userAssigned;

	public Task() {
		//super => to the object class constructor
		dueDate = LocalDate.now().plusDays(5); //due in 5 days
		description = "None provided";
	}
	public Task(String description) {
		this(); //will assign due date then description after, constructor chaining, 
		//invokes the no-args constructor before executing this constructor's logic
		this.description = description;
		
	}
	
	public void doTask() {
		System.out.println("Doing a task.");
	}
	public void doTask(String speed) {
		System.out.println("Doing task at " + speed + " speed");
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override //annotation just provides information to the compiler
	public int hashCode() {
		return Objects.hash(id, description, completed, dueDate, userAssigned);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (completed != other.completed)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (userAssigned == null) {
			if (other.userAssigned != null)
				return false;
		} else if (!userAssigned.equals(other.userAssigned))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", completed=" + completed + ", dueDate=" + dueDate
				+ ", userAssigned=" + userAssigned + "]";
	}
	
}
