package com.beanscope.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
public class ScopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScopeApplication.class, args);
	  System.out.println("");
	}

}
