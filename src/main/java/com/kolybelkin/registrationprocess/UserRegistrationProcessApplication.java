package com.kolybelkin.registrationprocess;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableProcessApplication
@SpringBootApplication
public class UserRegistrationProcessApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserRegistrationProcessApplication.class, args);
  }

}
