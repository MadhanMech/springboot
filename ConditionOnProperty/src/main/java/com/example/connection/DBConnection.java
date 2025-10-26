package com.example.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Profile("dev")
public class DBConnection {
	@Autowired(required = false)
	MySqlConnection mySqlConnection;
	@Autowired(required = false)//when false it just mark it as null ,and it don't distrub application flow
	NoSQLConnection noSQLConnection;
	
	@Value("Madhan1")
    private String name;
	
	@Value("${username}")
	 private String userName;
	
	@Value("${password}")
	private String password;
	
	@Value("${age}")
	private Integer age;
	
	@PostConstruct
	public void init() {
			System.out.println("DBConnection init");
			System.out.println("MySqlConnection :"+ mySqlConnection);
			System.out.println("NoSQLConnection :"+ noSQLConnection);
			System.out.println("MyName is :"+name+" age is : "+age);
			System.out.println("UserName is :"+userName+" Password is : "+password);
	}
}
