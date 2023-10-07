package com.rick.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

  @Override
  public String getDailyWorkout() {
    return "From TennisCoach!";
  }
}
