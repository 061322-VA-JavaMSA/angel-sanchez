package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	// created a REST API
	@GetMapping("/student") // URL: http://localhost8080/students
	public Student getStudent() {
		return new Student("Angel", "Sanchez"); // return a java object, in this case student with my name in JSON format
		// Spring MVC uses Jackson library to identify which java annotations to use
		// @ResponseBody uses HTTP Message converters to convert the return value to HTTP response body, based on content type in the request HTTP header
		}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Mendgy", "Moise"));
		students.add(new Student("Chad", "Mohan"));
		return students;
	}
	}