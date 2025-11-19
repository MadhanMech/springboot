package com.codesnippet.application_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Application;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.ApplicationRepository;

@Service
public class ApplicationService {
	   
	    @Autowired
		private final ApplicationRepository applicationRepository;
	    @Autowired
		private final ApplicantJpaRepository applicantJpaRpository;
		
		 public ApplicationService(ApplicationRepository applicationRepository,ApplicantJpaRepository applicantJpaRpository) {
			 this.applicationRepository=applicationRepository;
			 this.applicantJpaRpository=applicantJpaRpository;
		 }
		 
		 public Application saveApplication
		 (Long applicantId, Application application) {
		        // Fetch the applicant from DB
			  
		             
		        Applicant applicant = applicantJpaRpository.findById(applicantId)
		                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + applicantId));

		        // Link resume to the applicant
		        application.setApplicant(applicant);

		        // Save resume
		        return applicationRepository.save(application);
		    }
}
