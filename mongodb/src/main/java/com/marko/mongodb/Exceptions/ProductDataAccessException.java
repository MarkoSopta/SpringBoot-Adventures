package com.marko.mongodb.Exceptions;


import org.springframework.dao.DataAccessException;


public class ProductDataAccessException extends RuntimeException{
    public ProductDataAccessException(String message, DataAccessException ex) {
        super(message);
    }
}
