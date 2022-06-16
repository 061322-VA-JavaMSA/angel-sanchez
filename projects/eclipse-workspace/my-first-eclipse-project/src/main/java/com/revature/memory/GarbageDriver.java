package com.revature.memory;

public class GarbageDriver {
	
	public int id; //instance variable
	
	public GarbageDriver(int id) { //constructor takes int and sets it to id
		this.id = id;
	}

	public static void main(String[] args) {
		for(int i = 0; i < 10000; i++) { //creates a bunch of objects with no reference
			new GarbageDriver(i); //creating a type for garbage driver without assigning it to variable
			
			System.gc(); //need this for the console to print the garbage collection, runs the garbage collector, "gc"
		}

	}
	
	@Override //behavior of the method, tells compiler this is a subclass of the parent, uses Inheritance
	protected void finalize() { //the final method before garbage collection
		System.out.println("id: " + id + " has been garbage collected."); //prints out the id that has been garbage collected, won't be forced in order
	}

}
