package com.pm.applicationtracker.service;

import com.pm.applicationtracker.dto.CompanyRequest;
import com.pm.applicationtracker.dto.CompanyResponse;
import com.pm.applicationtracker.exception.ResourceNotFoundException;
import com.pm.applicationtracker.model.Company;
import com.pm.applicationtracker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyResponse> getCompanies() {
        return companyRepository.findAll().stream().map(this::toResponse).toList();
    }

    public CompanyResponse createCompany(CompanyRequest request) {
        Company company = new Company(request.name(), request.website(),  request.industry());
        Company saved  = companyRepository.save(company);
        return toResponse(saved);
    }

    public Company findCompanyOrThrow(Long id) {
        return companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Company not found"));
    }

    private CompanyResponse toResponse(Company company) {
        return new CompanyResponse(
                company.getId(), company.getName(), company.getWebsite(), company.getIndustry()
        );
    }

}
