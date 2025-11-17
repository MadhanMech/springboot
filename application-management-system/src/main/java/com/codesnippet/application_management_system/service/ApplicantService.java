package com.codesnippet.application_management_system.service;

import com.codesnippet.application_management_system.Entity.Applicant;
import com.codesnippet.application_management_system.repositories.ApplicantCrudRepository;
import com.codesnippet.application_management_system.repositories.ApplicantJpaRepository;
import com.codesnippet.application_management_system.repositories.ApplicantPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantCrudRepository applicantCrudRepository;
    @Autowired
    private ApplicantPagingAndSortingRepository applicantPagingAndSortingRepository;
    @Autowired
    private ApplicantJpaRepository applicantJpaRepository;
    public List<Applicant> getAllApplicants() {
       return applicantCrudRepository.findAll();
    }
    public List<Applicant> getApplicantByStatus(String status) {
        return applicantJpaRepository.findByStatusOrderByNameAsc(status);
    }
    public List<Applicant> getApplicantByPartialName(String name) {
        return applicantJpaRepository.findApplicantsByPartialName(name);
    }
    public Applicant saveApplicantCrud(Applicant applicant) {
       return applicantCrudRepository.save(applicant);
    }

    public Iterable<Applicant> getApplicantsWithPagination(int page, int size) {
        return applicantPagingAndSortingRepository.findAll(PageRequest.of(page,size));
    }

}
