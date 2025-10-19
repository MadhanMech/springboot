package com.beanscope.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope("singleton")
public class User {
	public User() {
		System.out.println("User Initialized");
	}
	
	@PostConstruct
    public void init() {
    	System.out.println("User Object HashCode:"+this.hashCode());
    }
	
	
}
