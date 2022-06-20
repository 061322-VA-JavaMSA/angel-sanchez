package com.revature.oop;
import java.time.LocalDate;

import com.revature.oop.daos.TaskDAO;
import com.revature.oop.daos.TaskOracle;
import com.revature.oop.daos.TaskPostgres;
import com.revature.oop.models.BoringTask;
import com.revature.oop.models.Task;

public class Driver {

	public static void main(String[] args) {
		Task t = new Task(); //create class instance from the task class
		
//		System.out.println(t.dueDate);
//		System.out.println(t.completed); //false by default
//		System.out.println(t.description);
		
		System.out.println();
		
		Task t1 = new Task("Do laundry.");
		System.out.println(t1.getDueDate());
		System.out.println(t1.isCompleted()); //false by default
		System.out.println(t1.getDescription());
		
		t1.setDueDate(LocalDate.now().minusYears(4));
		System.out.println(t1.getDueDate());
		
		System.out.println();
		
		BoringTask t2 = new BoringTask("laundry");
		System.out.println(t2.getDueDate());
		System.out.println(t2.isCompleted());
		System.out.println(t2.getDescription());
		
		System.out.println(t1.toString());
		System.out.println(t2);
		
		System.out.println();
		
		Task t3 = new BoringTask();
		System.out.println(t3.toString());
		
//		BoringTask t4 = new BoringTask();
//		t4.boringTaskSpecificMethod();
		
		TaskDAO td = new TaskOracle();
		td.addTask(t3);
	}

}
