package com.codesnippet.application_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codesnippet.application_management_system.Entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {

	
}
