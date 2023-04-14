package com.marko.mongodb.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@Builder
@Document
public class Category {
    @Id
    @NotNull
    private String id;
    private String name;
    private String description;
}
