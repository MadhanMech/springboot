
package com.security.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entitly.User;
import com.security.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
public class UserService implements InitializingBean, DisposableBean {
	 
	
	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		System.out.println("UserService Created");
	}


	
	
	public User createUser(User user) {
		userRepository.save(user);
		 return user;
	}

	@Override
	
	public void afterPropertiesSet() throws Exception {
		System.out.println("Action After Bean Created");
		
	}


    @PostConstruct
	public void annotationBasedBeanInitilztaion() throws Exception {
		System.out.println("Action After Bean Created triggred by anotation");
		
	}
    @PreDestroy
	public void annotationBasedBeanDestroy() throws Exception {
		System.out.println("Action After Bean Created triggred by anotation");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Action Before Destroying Bean ");
		
	}


 
}
