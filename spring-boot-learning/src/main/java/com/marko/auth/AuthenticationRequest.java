package com.marko.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents an authentication request. It is used to store the email and password of a user attempting to authenticate. 
 * It is part of the com.marko.auth package and uses Lombok annotations for convenience. 
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String email;
    private String password;
}
