package com.example.ConditionOnProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class ConditionOnPropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConditionOnPropertyApplication.class, args);

	}

}
