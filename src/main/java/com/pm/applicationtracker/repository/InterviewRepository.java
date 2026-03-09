package com.pm.applicationtracker.repository;

import com.pm.applicationtracker.model.Application;
import com.pm.applicationtracker.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview,Long> {
    List<Interview> findByApplicationId(Long applicationId);
}
