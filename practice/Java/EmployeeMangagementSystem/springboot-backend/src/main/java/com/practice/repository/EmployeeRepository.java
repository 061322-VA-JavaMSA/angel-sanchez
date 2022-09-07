package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Employee;

// JpaRepository doesn't require us to use the annotations @Transactional/@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
