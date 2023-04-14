package com.marko.mongodb.Repository;

import com.marko.mongodb.Model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category,String> {
}
