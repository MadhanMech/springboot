package com.beanscope.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beanscope.entity.Employee;
import com.beanscope.scope.ScopeApplication;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
@Scope("prototype")
public class UserController {


	@Autowired
	 Employee employee;

	public UserController(ScopeApplication scopeApplication) {
		System.out.println("UserContoller Initited");
	
	}
	
	
	@PostConstruct
	public void init() {
		System.out.println("User Controller Hashcode"+this.hashCode()+"Employee hash code"+employee.hashCode());
	}
	
	
	@GetMapping("/fetchUser1")
	public ResponseEntity<String>getUserDetails(){
		
		System.out.println("Fetch User Api");
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
	
	
	
  
	
}
