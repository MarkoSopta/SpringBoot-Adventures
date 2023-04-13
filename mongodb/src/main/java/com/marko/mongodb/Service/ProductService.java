package com.marko.mongodb.Service;

import com.marko.mongodb.DTOs.SaveProductDTO;
import com.marko.mongodb.Exceptions.ProductDataAccessException;
import com.marko.mongodb.Model.Product;
import com.marko.mongodb.Exceptions.ProductNotFoundException;
import com.marko.mongodb.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repo;

    public String saveProduct(SaveProductDTO saveProductDTO) {
        Product product = new Product(saveProductDTO.name(), saveProductDTO.description());
        Product savedProduct = repo.save(product);
        return savedProduct.getId();
    }

    public Product findById(String id) {
        Optional<Product> optionalProduct = repo.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new ProductNotFoundException("Product not found for ID: " + id);
        }
    }

    public List<Product> findAll() {
        try {
            return repo.findAll();
        } catch (DataAccessException ex) {
            throw new ProductDataAccessException("Failed to retrieve products from the repository.", ex);
        }
    }


    public void deleteById(String id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ProductNotFoundException("Product not found for ID: " + id);
        }
    }
}