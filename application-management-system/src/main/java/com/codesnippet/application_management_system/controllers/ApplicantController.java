package com.codesnippet.application_management_system.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Resume;
import com.codesnippet.application_management_system.service.ApplicantService;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }
    @PostMapping
    public Applicant saveApplicant(@RequestBody Applicant applicant) {

        // 1. One-to-One Resume
        Resume resume = applicant.getResume();
        if (resume != null) {
            resume.setApplicant(applicant);
        }

      
        if (applicant.getApplication() != null) {
            applicant.getApplication().forEach(application -> {
                application.setApplicant(applicant); // <-- important
            });
        }

        return applicantService.saveApplicantCrud(applicant);
    }


    @GetMapping("/page")
    public Iterable<Applicant> getApplicantsWithPagination(
            @RequestParam int page,
            @RequestParam int size) {
        return applicantService.getApplicantsWithPagination(page, size);
    }
    @GetMapping("/getByStatus")
    public List<Applicant> getApplicantByStatus(@RequestParam String status) {
        return applicantService.getApplicantByStatus(status);
    }
    @GetMapping("/getByName")
    public List<Applicant> getApplicantByPartialName(@RequestParam String name) {
        return applicantService.getApplicantByPartialName(name);
    }
}
