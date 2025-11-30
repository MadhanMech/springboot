package com.codesnippet.application_management_system.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String status;

    @OneToOne(mappedBy ="applicant",cascade = CascadeType.ALL)//should small not capital not Applicant ,applicant is correct,this cascade use before applicant insert  ,resume will added
    private Resume resume;
    
    @OneToMany(mappedBy ="applicant",cascade = CascadeType.ALL)//should small not capital not Applicant ,applicant is correct,this cascade use before applicant insert  ,application  will added
    private List<Application> application=new ArrayList<>(); 
    
    @ManyToMany
    @JoinTable(name="applicants_jobs",joinColumns= @JoinColumn(name="applicantId"),inverseJoinColumns = @JoinColumn(name="jobId"))
     private List<Job>jobs=new ArrayList<>();

	public List<Job> getJob() {
		return jobs;
	}

	public void setJob(List<Job> job) {
		this.jobs= job;
	}

	public List<Application> getApplication() {
		return application;
	}

	public void setApplication(List<Application> application) {
		this.application = application;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }
    

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
