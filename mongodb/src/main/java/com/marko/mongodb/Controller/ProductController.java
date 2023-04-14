package com.marko.mongodb.Controller;

import com.marko.mongodb.DTOs.SaveProductDTO;
import com.marko.mongodb.Model.Product;
import com.marko.mongodb.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(
            @PathVariable("id") String productId
    ) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @PostMapping
    public ResponseEntity<String> save(
            @RequestBody SaveProductDTO product
    ) {
        return ResponseEntity.ok(service.saveProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") String productId
    ) {
        service.deleteById(productId);
        return ResponseEntity.accepted().build();
    }

}
