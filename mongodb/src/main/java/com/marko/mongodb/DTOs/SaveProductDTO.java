package com.marko.mongodb.DTOs;

import jakarta.validation.constraints.NotBlank;

public record SaveProductDTO(
        @NotBlank(message="Name is required")
        String name,
        String description
) {
}
