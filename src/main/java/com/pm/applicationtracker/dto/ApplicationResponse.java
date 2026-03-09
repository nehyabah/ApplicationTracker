package com.pm.applicationtracker.dto;

import com.pm.applicationtracker.model.ApplicationStatus;

import java.time.LocalDate;

public record ApplicationResponse(
         Long id,
         String position,
         double minSalary,
         double maxSalary,
         LocalDate dateApplied,
         String notes,
         ApplicationStatus status,
         String companyName
         ) {
}
