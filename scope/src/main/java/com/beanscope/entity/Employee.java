package com.beanscope.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("singleton")
public class Employee {
	public Employee() {
		System.out.println("Employee Initialized");
	}
	
	@PostConstruct
    public void init() {
    	System.out.println("Employee Object HashCode:"+this.hashCode());
    }
	
	
}
