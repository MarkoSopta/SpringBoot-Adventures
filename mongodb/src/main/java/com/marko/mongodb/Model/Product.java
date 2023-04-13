package com.marko.mongodb.Model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
