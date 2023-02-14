package com.marko.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/*
 * This is a Java class that is used to authenticate a user. 
 * It extends the OncePerRequestFilter class, which ensures that the filter is only executed once per request. 
 * The class has two private fields: jwtService and userDetailsService. 
 * The doFilterInternal() method is overridden to check for a valid JWT token in the Authorization header of the request. 
 * If a valid token is found, it extracts the username from it and uses the userDetailsService to load the UserDetails object associated with that username. 
 * If the token is valid, it creates an authentication token and updates the SecurityContextHolder with it before sending the request to DispatcherServlet.
*/

@Service
public class JwtService {

    // https://www.allkeysgenerator.com/random/Security-encryption-key-generator.aspx
    private static final String SECRET_KEY="38782F413F4428472B4B6250655367566B597033733676397924422645294840";

    public String extractUsername(String token) {
        return extractClaim(token,Claims::getSubject);
    }


    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims  claims=extractAllClaims(token);
        return claimsResolver.apply(claims);

    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    // method to help generate a token
    public String generateToken(Map<String,
            Object> extraClaims,
            UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //method to validate token

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);
    }
    //checking if the token expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    //getting the expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }


    private Claims extractAllClaims(String token){

        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build().parseClaimsJws(token)
                .getBody();

    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
