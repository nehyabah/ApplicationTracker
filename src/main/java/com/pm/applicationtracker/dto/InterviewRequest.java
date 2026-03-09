package com.pm.applicationtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record InterviewRequest(
        @NotNull(message ="Date is required")
        LocalDate date,

        @NotNull(message ="Time is required")
        LocalTime time,
        @NotBlank(message ="interviewer name is required")
        String interviewerName,

        String notes,

        @NotBlank(message = "Interview type is required")
        String interviewType,

        @NotNull(message = "Application ID is required")
        Long applicationId
) {
}
