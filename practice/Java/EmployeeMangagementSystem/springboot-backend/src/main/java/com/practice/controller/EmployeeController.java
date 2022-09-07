package com.practice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Employee;
import com.practice.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController{
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build create employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	//build get all employees REST API
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	// build get employee by id REST API
	// http://localhost:8080/api/employees/{id}
	@GetMapping("{id}") // to set the path variable, makes it dynamic
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		// public 
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK); //return employee with status code 201
	}
	
	// build update employee REST API
	// http://localhost:8080/api/employees/{id}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
		// @PathVariable in order to change the dynamic employee id variable
		// @RequestBody to update and return the employee in JSON format
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}
	
	// build delete employee REST API
	// http://localhost:8080/api/employees/{id}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		// delete employee from DB
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}

}
