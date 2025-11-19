package com.codesnippet.application_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Job;
import com.codesnippet.application_management_system.service.JobService;

@RequestMapping("/api/jobs")
@Controller
public class JobController {

	@Autowired
	private JobService jobService;
	
	@PostMapping
	public ResponseEntity<Job>createJobs(@RequestBody Job job){
		 Job createdJob=jobService.createJob(job);
		 return ResponseEntity.status(HttpStatus.OK).body(createdJob);
	}
	
	@PostMapping("/add-job-to-applicant")
	public ResponseEntity<Applicant>addJobToApplicant(@RequestParam Long applicantId, @RequestParam Long jobId){
		Applicant updateApplicant=jobService.addJobToApplicant(applicantId, jobId);
		return ResponseEntity.status(HttpStatus.OK).body(updateApplicant);
	}
	
	
	
	
	
}
