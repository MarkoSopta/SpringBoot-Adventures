package com.marko.mongodb.Exceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.dao.DataAccessException;

@AllArgsConstructor
@NoArgsConstructor
public class ProductDataAccessException extends RuntimeException{
    public ProductDataAccessException(String message, DataAccessException ex) {
        super(message);
    }
}
