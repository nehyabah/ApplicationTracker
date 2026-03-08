package com.pm.applicationtracker.dto;

public record CompanyResponse(
        Long id,
        String name,
        String website,
        String industry

) {
}
