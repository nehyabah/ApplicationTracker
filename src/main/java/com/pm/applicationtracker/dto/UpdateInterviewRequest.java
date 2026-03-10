package com.pm.applicationtracker.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record UpdateInterviewRequest(
        LocalDate date,
        LocalTime time,
        String interviewerName,
        String notes,
        String outcome
) {
}
