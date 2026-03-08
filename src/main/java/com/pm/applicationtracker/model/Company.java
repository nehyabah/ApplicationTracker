package com.pm.applicationtracker.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String website;
    private String industry;

    public Company() {
    }

    public Company(String name, String industry, String website) {
        this.name = name;
        this.industry = industry;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getIndustry() {
        return industry;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
