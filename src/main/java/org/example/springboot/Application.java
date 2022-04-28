package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing  //=> JPA Configure로 옮겼음
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class , args); //WAS 설정

    }
}

