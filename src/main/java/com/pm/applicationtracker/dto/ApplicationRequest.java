package com.pm.applicationtracker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ApplicationRequest(
        @NotBlank(message = "Position is required")
        String position,

        @Min(value = 0, message = "Min Salary must be positive")
        double minSalary,

        @Min(value = 0, message = "Max salary value must be positive")
        double maxSalary,


        @NotBlank(message = "Date is required")
        LocalDate dateApplied,

        String notes,

        @NotBlank(message = "Company ID is required")
        Long companyId


) {
}
