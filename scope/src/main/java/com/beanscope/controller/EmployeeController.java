package com.beanscope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beanscope.entity.User;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
@Scope("session")
public class EmployeeController {
	@Autowired
	 User user;
	public EmployeeController() {
		System.out.println("Enloyee Controller Init");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Employee Controller HashCode : "+this.hashCode() +
		"User Object HashCode : "+user.hashCode());
		
	}
	
	@GetMapping("/fetchUser")
	public ResponseEntity<String>getUserDetails(){
		
		
		return ResponseEntity.status(HttpStatus.OK).body("Ok");
		
	}
	@GetMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return ResponseEntity.status(HttpStatus.OK).body("logged out successfully");
		
	}
	
}
