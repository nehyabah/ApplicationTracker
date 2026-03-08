package com.pm.applicationtracker.dto;

import java.time.LocalDate;

public record ApplicationResponse(
         Long id,
         String position,
         double minSalary,
         double maxSalary,
         LocalDate dateApplied,
         String notes,
         String status,
         Long companyName
         ) {
}
