package com.sparta.sparta_assignment_week3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaAssignmentWeek3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpartaAssignmentWeek3Application.class, args);
    }

}
