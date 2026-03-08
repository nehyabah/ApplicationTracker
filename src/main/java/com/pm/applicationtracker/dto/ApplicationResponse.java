package com.pm.applicationtracker.dto;

import java.time.LocalDate;

public record ApplicationResponse(

         String position,
         float salaryRange,
         LocalDate dateApplied) {
}
