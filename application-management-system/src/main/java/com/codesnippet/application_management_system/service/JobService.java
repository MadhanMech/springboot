package com.codesnippet.application_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.Entity.Job;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.JobRepository;

@Service
public class JobService {
	
    @Autowired
    private ApplicantJpaRepository applicantRepository;
	
    @Autowired
    private JobRepository jobRepository;

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Applicant addJobToApplicant(Long applicantId, Long jobId) {

        Applicant applicant = applicantRepository.findById(applicantId)
                .orElseThrow(() -> new IllegalArgumentException("Applicant not found"));

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new IllegalArgumentException("Job not found"));

        // update both sides (only correct if Many-to-Many)
        applicant.getJob().add(job);
        job.getApplicant().add(applicant);

        return applicantRepository.save(applicant);
    }
}