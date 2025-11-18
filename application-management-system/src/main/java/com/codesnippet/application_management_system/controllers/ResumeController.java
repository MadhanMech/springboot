package com.codesnippet.application_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.service.ResumeService;


@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ApplicantController applicantController;
 
	@Autowired
	private ResumeService resumeService;


    ResumeController(ApplicantController applicantController) {
        this.applicantController = applicantController;
    }
	
	
	 @PostMapping("/{applicantId}/save")
	  public ResponseEntity<Resume>saveResume(@PathVariable Long applicantId ,@RequestBody Resume resume){
		    
		  System.out.println("applicantId"+applicantId);
		   return ResponseEntity.status(HttpStatus.CREATED).body(resumeService.saveResume(applicantId,resume));
	  }
	
}
