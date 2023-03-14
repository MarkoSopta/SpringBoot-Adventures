package com.marko.user;

/*
This code is a Java class that creates a repository for the User class. 
It extends JpaRepository and uses the generic types User and Integer. 
It also contains a method findByEmail which takes in a String parameter and returns an Optional of type User. 
This method is used to fetch a user by their email address.
*/

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    //fetch user by email
    Optional<User> findByEmail(String email);
}
