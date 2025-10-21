package com.example.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DBConnection {
	@Autowired(required = false)
	MySqlConnection mySqlConnection;
	@Autowired(required = false)//when false it just mark it as null ,and it don't distrub application flow
	NoSQLConnection noSQLConnection;
	
	@PostConstruct
	public void init() {
			System.out.println("DBConnection init");
			System.out.println("MySqlConnection :"+ mySqlConnection);
			System.out.println("NoSQLConnection :"+ noSQLConnection);
	}
}
