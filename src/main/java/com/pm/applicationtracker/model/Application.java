package com.pm.applicationtracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String position;
    private double minSalary;
    private double maxSalary;
    private LocalDate dateApplied;
    private String notes;


    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


    public Application() {
    }

    public Application(String position, double minSalary, double maxSalary, LocalDate dateApplied, String notes, ApplicationStatus status, Company company) {
        this.position = position;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.dateApplied = dateApplied;
        this.notes = notes;
        this.status = status;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public String getNotes() {
        return notes;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
