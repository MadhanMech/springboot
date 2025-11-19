package com.codesnippet.application_management_system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.application_management_system.Entity.Application;
import com.codesnippet.application_management_system.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

	 @Autowired
    private final ApplicationService applicationService;

    // Constructor injection (Recommended)
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/{applicantId}/save")
    public ResponseEntity<Application> saveResume(
            @PathVariable Long applicantId,
            @RequestBody Application application) {

        System.out.println("Applicant ID: " + applicantId);

        Application saved = applicationService.saveApplication(applicantId, application);

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
