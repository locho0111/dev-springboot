package com.rick.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private Coach myCoach;
	
	@Autowired
	public DemoController(Coach myCoach) {
		super();
		this.myCoach = myCoach;
	}
	
	@GetMapping("/getDailyWorkout")
	public String gatDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
