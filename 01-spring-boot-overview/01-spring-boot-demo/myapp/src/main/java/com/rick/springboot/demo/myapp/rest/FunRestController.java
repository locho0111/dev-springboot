package com.rick.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// expose "/" that return "Hello World!"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World!";
	}

	@GetMapping("/say-hi")
	public String sayHi() {
		return "Hi There!";
	}
	
	@Value("${my.name}")
	private String myName;
	
	@GetMapping("/my-name")
	public String sayMyName() {
		return myName;
	}
}
