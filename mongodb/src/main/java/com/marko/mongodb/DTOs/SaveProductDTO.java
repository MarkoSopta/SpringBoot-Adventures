package com.marko.mongodb.DTOs;

import com.marko.mongodb.Model.Category;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record SaveProductDTO(
        @NotBlank(message="Name is required")
        String name,
        String description,
        List<String> tags,

        Category category
        
        ) {

}
