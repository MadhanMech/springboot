package com.codesnippet.application_management_system.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Resume {
   
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String content;
	 @OneToOne
	 @JoinColumn(name = "applicantId",nullable = false)
	 @JsonIgnore
	 private Applicant applicant;
	 
	 
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getContent() {
		 return content;
	 }
	 public void setContent(String content) {
		 this.content = content;
	 }
	 public Applicant getApplicant() {
		 return applicant;
	 }
	 public void setApplicant(Applicant applicant) {
		 this.applicant = applicant;
	 }
	
}
