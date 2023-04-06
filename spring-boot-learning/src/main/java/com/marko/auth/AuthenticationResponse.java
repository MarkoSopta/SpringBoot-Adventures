package com.marko.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * This code is creating a Java class called AuthenticationResponse.
 * The class has one field, "token", and has methods for getting and setting the value of the token. 
 * It also has annotations for Lombok which will generate additional methods such as toString(), equals(), and hashCode().
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
