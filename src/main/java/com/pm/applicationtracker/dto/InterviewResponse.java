package com.pm.applicationtracker.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record InterviewResponse(
        Long id,
        LocalDate date,
        LocalTime time,
        String interviewerName,
        String notes,
        String outcome,
        String interviewType,
        String applicationPosition

) {
}
