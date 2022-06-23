package com.revature.oop.daos;

import com.revature.oop.models.Task;

public interface TaskDAO {
	//declare methods to be implemented
	//the role of DAO is to handle data persistence, store data into a DB
	public abstract Task getTaskById(int id);
	Task addTask(Task newTask); //implicitly public and abstract
	
//	 default boolean deleteTask(int id) {
//		 return true;
//	 }
	
//	boolean deleteTask(int id); //breaks the other classes in DAO because it needs to be implemented

}
