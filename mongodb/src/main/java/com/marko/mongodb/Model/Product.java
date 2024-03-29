package com.marko.mongodb.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Product {

    @Id
    @NotNull
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    private Category category;

    public Product(String name, String description, List<String> tags, Category category) {
        this.name = name;
        this.description = description;
        this.tags=tags;
        this.category=category;
    }
}
