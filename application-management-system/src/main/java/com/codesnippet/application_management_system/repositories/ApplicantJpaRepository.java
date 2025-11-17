package com.codesnippet.application_management_system.repositories;

import com.codesnippet.application_management_system.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantJpaRepository extends JpaRepository<Applicant,Long> {
   List<Applicant> findByStatusOrderByNameAsc(String status);

    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
    List<Applicant> findApplicantsByPartialName(@Param("name") String name);

}
