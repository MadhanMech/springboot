package com.beanscope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.beanscope.entity.User;

import jakarta.annotation.PostConstruct;



@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	User user;
	
	public EmployeeController() {
		System.out.println("Employee Controller Init");
	}
	
	@PostConstruct
	
	public void init() {
		System.out.println("Employee Controller Hashcode :" +this.hashCode()+
		"User Object HashCode:"+user.hashCode());
		
	}
	@GetMapping("/fetchUser")
	public ResponseEntity<String>getUserDetails(){
		System.out.println("Fetch user api");
		return ResponseEntity.status(HttpStatus.OK).body("OK");
		
	}
	
	

}
