package com.codesnippet.SpringBatchDemo.repository;

import com.codesnippet.SpringBatchDemo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
