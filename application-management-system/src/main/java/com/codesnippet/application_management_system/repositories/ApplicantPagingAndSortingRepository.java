package com.codesnippet.application_management_system.repositories;

import com.codesnippet.application_management_system.Entity.Applicant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicantPagingAndSortingRepository extends ListPagingAndSortingRepository<Applicant,Long> , CrudRepository<Applicant,Long> {
}
