package com.codesnippet.application_management_system.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


 
	@Autowired
	private ResumeService resumeService;


 
	
	
	 @PostMapping("/{applicantId}/save")
	  public ResponseEntity<Resume>saveResume(@PathVariable Long applicantId ,@RequestBody Resume resume){
		    
		 
		   return ResponseEntity.status(HttpStatus.CREATED).body(resumeService.saveResume(applicantId,resume));
	  }
	 
	 @GetMapping("/{id}")
	  public ResponseEntity<?>getResumeById(@PathVariable Long id ){
		    
			try {
				 return ResponseEntity.status(HttpStatus.CREATED).body(resumeService.getResumeById(id));
			}
			catch(RuntimeException e) {
				Map<String, String> error = new HashMap<>();
		        error.put("message", e.getMessage());
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
			}
		  
	  }
	
}
