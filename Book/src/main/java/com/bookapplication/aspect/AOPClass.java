package com.bookapplication.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPClass {

	@Pointcut("execution(* com.bookapplication.service.*.*(..))") 
    private void addBookPointCut() {}

 
	
	
	@Before("addBookPointCut()")
	public void beforAddBook() {
		
		
		System.out.println("Book is added successfully");
		
	}
	
	
}
