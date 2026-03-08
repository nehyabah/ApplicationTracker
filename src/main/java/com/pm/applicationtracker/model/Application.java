package com.pm.applicationtracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String position;
    private float salaryRange;
    private LocalDate dateApplied;


    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Application() {
    }

    public Application(String position, float salaryRange, LocalDate dateApplied, ApplicationStatus status) {
        this.position = position;
        this.salaryRange = salaryRange;
        this.dateApplied = dateApplied;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public float getSalaryRange() {
        return salaryRange;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalaryRange(float salaryRange) {
        this.salaryRange = salaryRange;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}
