package com.beanscope.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Employee {
	  @Autowired	
		User user;
	public Employee() {
		System.out.println("Employee Initated");
	}
    @PostConstruct
	public void init() {
		System.out.println("Employee Object HashCode : "+this.hashCode());
	}
	
}
