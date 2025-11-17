package com.codesnippet.application_management_system.repositories;

import com.codesnippet.application_management_system.Entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface ApplicantCrudRepository extends ListCrudRepository<Applicant,Long> {
}
