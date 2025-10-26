package com.bookapplication.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bookapplication.service.OfflineBookService;

@SpringBootApplication
@ComponentScan(basePackages = "com.*",excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE,classes = OfflineBookService.class))
@EnableAutoConfiguration
@EntityScan(basePackages = "com.bookapplication.model")
@EnableTransactionManagement
@EnableAspectJAutoProxy //not need spring boot application internally having it.
@EnableJpaRepositories(basePackages = "com.bookapplication.repository")
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
		System.out.println("dfdads");
	}

}
