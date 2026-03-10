package com.pm.applicationtracker.controller;

import com.pm.applicationtracker.dto.ApplicationRequest;
import com.pm.applicationtracker.dto.ApplicationResponse;

import com.pm.applicationtracker.model.ApplicationStatus;
import com.pm.applicationtracker.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<ApplicationResponse> getApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/{id}")
    public ApplicationResponse getApplication(@PathVariable Long id) {
        return applicationService.getApplication(id);
    }

    @PostMapping
    public ApplicationResponse createApplication(@Valid @RequestBody ApplicationRequest request) {
        return applicationService.createApplication(request);

    }
    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
    }

    @GetMapping("/status/{status}")
    public List<ApplicationResponse> getApplicationsByStatus(@PathVariable ApplicationStatus status) {
        return applicationService.getApplicationsByStatus(status);
    }

    @GetMapping("/company/{companyId}")
    public List<ApplicationResponse> getApplicationsByCompany(@PathVariable Long companyId) {
        return applicationService.getApplicationsByCompany(companyId);
    }

}
