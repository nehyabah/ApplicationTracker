package com.pm.applicationtracker.service;

import com.pm.applicationtracker.dto.ApplicationRequest;
import com.pm.applicationtracker.dto.ApplicationResponse;
import com.pm.applicationtracker.exception.ResourceNotFoundException;
import com.pm.applicationtracker.model.Application;
import com.pm.applicationtracker.model.ApplicationStatus;
import com.pm.applicationtracker.model.Company;
import com.pm.applicationtracker.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CompanyService companyService;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository, CompanyService companyService) {
        this.applicationRepository = applicationRepository;
        this.companyService = companyService;

    }

    public List<ApplicationResponse> getAllApplications() {
        return applicationRepository.findAll().stream().map(this::toResponse).toList();

    }

    public ApplicationResponse createApplication(ApplicationRequest request) {
        Company company = companyService.findCompanyOrThrow(request.companyId());
        Application application = new Application(
                request.position(),
                request.minSalary(),
                request.maxSalary(),
                request.dateApplied(),
                request.notes(),
                ApplicationStatus.APPLIED,
                company
        );
        applicationRepository.save(application);
        return toResponse(application);
    }

    public Application findApplicationOrThrow(Long id) {
        return applicationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Application with id " + id + " not found"));
    }


    private ApplicationResponse toResponse(Application application) {
        return new ApplicationResponse(application.getId(), application.getPosition(), application.getMinSalary(), application.getMaxSalary(), application.getDateApplied(), application.getNotes(), application.getStatus(), application.getCompany().getName()
        );
    }
}
