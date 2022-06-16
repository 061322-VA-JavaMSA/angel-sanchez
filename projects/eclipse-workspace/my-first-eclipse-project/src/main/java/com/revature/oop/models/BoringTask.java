package com.revature.oop.models;

public class BoringTask extends Task{

	public BoringTask() {
		super("Hello World!");
		// TODO Auto-generated constructor stub
	}

	public BoringTask(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BoringTask [getDescription()=" + getDescription() + ", isCompleted()=" + isCompleted()
				+ ", getDueDate()=" + getDueDate() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
	
	public void boringTaskSpecificMethod() {
		System.out.println("This is only for boring task.");
	}
	
}
