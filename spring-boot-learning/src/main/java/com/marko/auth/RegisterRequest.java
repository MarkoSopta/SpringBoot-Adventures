package com.marko.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * This code creates a class called RegisterRequest which contains four fields: firstname, lastname, email, and password. 
 * The @Data annotation is used to generate getters and setters for the fields, @Builder is used to create a builder for the class,
 * and @AllArgsConstructor and @NoArgsConstructor are used to generate constructors with all arguments or no arguments respectively.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

}
