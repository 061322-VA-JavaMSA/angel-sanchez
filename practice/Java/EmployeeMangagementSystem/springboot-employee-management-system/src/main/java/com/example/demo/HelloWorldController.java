package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller //
//@ResponseBody //converts java to JSON
@RestController //combines both the above annotations, handles HTTP requests
public class HelloWorldController {
	
	@GetMapping("/hello-world") // URL to call this method
	public String helloWorld() {
		return "Hello World!";
	} // GET end point, http://localhost:8080/hello-world
	
}
