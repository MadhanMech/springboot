package com.beanscope.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope(value="request",proxyMode = ScopedProxyMode.TARGET_CLASS)//proxy mode only requied for singlton not for prototyp
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
