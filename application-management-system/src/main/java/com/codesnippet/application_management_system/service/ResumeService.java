package com.codesnippet.application_management_system.service;

import org.springframework.stereotype.Service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.ResumeRepository;

@Service 
public class ResumeService {
   
	private final ResumeRepository resumeRepository;
	private final ApplicantJpaRepository applicantJpaRpository;
	
	 public ResumeService(ResumeRepository resumeRepository,ApplicantJpaRepository applicantJpaRpository) {
		 this.resumeRepository=resumeRepository;
		 this.applicantJpaRpository=applicantJpaRpository;
	 }
	 
	 public Resume saveResume(Long applicantId, Resume resume) {
	        // Fetch the applicant from DB
	        Applicant applicant = applicantJpaRpository.findById(applicantId)
	                .orElseThrow(() -> new RuntimeException("Applicant not found with id: " + applicantId));

	        // Link resume to the applicant
	        resume.setApplicant(applicant);

	        // Save resume
	        return resumeRepository.save(resume);
	    }
	
}
