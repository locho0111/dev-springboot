package com.rick.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
  scanBasePackages = { "com.rick.springcoredemo", "com.rick.util" }
)
public class SpringcoredemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringcoredemoApplication.class, args);
  }
}
