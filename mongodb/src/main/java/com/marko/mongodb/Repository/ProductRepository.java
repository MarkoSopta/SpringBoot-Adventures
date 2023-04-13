package com.marko.mongodb.Repository;

import com.marko.mongodb.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {

}
