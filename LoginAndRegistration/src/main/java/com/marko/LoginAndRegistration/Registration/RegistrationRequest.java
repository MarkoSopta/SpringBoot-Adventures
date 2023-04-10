package com.marko.LoginAndRegistration.Registration;

public record RegistrationRequest
        (
         String firstName,
         String lastName,
         String email,
         String password) {

}
