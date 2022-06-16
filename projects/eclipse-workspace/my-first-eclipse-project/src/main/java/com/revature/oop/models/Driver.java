package com.revature.oop.models;
import com.revature.oop.models.Task;

public class Driver {

	public static void main(String[] args) {
		Task t = new Task(); //create class instance from the task class
		
		System.out.println(t.dueDate);
		System.out.println(t.completed); //false by default
		System.out.println(t.description);
		System.out.println();
		
		Task t1 = new Task("Do laundry.");
		System.out.println(t1.dueDate);
		System.out.println(t1.completed); //false by default
		System.out.println(t1.description);

	}

}
