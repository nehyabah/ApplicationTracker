package com.pm.applicationtracker.dto;

import jakarta.validation.constraints.NotBlank;

public record CompanyRequest(
        @NotBlank(message = "Company name is required")
        String name,

        @NotBlank(message = "Industry is required")
        String industry,

        @NotBlank(message = "Website is required")
        String website
) {
}
