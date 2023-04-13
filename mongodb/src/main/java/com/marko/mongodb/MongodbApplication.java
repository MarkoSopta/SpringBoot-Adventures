package com.marko.mongodb;

import com.marko.mongodb.Model.Product;
import com.marko.mongodb.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr(
        ProductRepository prepo
    ) {
        return args -> {
            var product = Product.builder()
                    .name("TestProduct1")
                    .description("TestDesc1")
                    .build();
            prepo.insert(product);
        };
    }

}
