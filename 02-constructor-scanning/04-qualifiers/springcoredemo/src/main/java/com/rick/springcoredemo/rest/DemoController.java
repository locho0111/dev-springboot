package com.rick.springcoredemo.rest;

import com.rick.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  private Coach myCoach;

  // @Qualifier > @Primary
  @Autowired
  public DemoController(@Qualifier("tennisCoach") Coach myCoach) {
    super();
    this.myCoach = myCoach;
  }

  @GetMapping("/getDailyWorkout")
  public String gatDailyWorkout() {
    return myCoach.getDailyWorkout();
  }
}
