package com.securty.jwt_security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.*")
@EntityScan(basePackages="com.*")
@ComponentScan(basePackages="com.*")
public class JwtSecurityApplication {

	public static void main(String[] args) {
	  ConfigurableApplicationContext context=	SpringApplication.run(JwtSecurityApplication.class, args);
//	  context.close();// Stop run application manually
//	   String[] beanNames = context.getBeanDefinitionNames();
//
//       System.out.println("==== Loaded Beans ====");
//       for (String name : beanNames) {
//           System.out.println(name);
//       }
//
//       System.out.println("Total Beans Loaded: " + beanNames.length);
	}

}
