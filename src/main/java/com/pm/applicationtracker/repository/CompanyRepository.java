package com.pm.applicationtracker.repository;

import com.pm.applicationtracker.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
