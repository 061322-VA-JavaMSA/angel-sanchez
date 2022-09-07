package com.practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.practice.exception.ResourceNotFoundException;
import com.practice.model.Employee;
import com.practice.repository.EmployeeRepository;
import com.practice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> employee = employeeRepository.findById(id); //pass in the long id into the method from ER
//		if(employee.isPresent()) { // check if the employee is present in DB
//			return employee.get(); //return the employee by id
//		} else {
//			throw new ResourceNotFoundException("Employee", "Id", id); // throw this error if employee not found
//		}
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		// this uses LAMBDA to reduce boiler plate code when checking if the employee exists and return them by Id
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// check whether the employee with a given id exists in DB
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether employee exists in DB or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}