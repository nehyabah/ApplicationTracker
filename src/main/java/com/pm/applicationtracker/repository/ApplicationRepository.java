package com.pm.applicationtracker.repository;

import com.pm.applicationtracker.model.Application;
import com.pm.applicationtracker.model.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

import java.util.List;

public interface ApplicationRepository extends JpaRepository <Application,Long>{
    List<Application> findByCompanyId(Long id);
    List<Application> findByStatus(ApplicationStatus status);
    List<Application> findByDateAppliedBetween(LocalDate start, LocalDate end);

}
