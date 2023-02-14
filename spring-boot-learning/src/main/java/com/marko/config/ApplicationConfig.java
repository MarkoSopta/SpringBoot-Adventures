package com.marko.config;

import com.marko.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
This is a Java configuration class for the Spring Security framework. 
The @Configuration annotation indicates that this class contains bean definitions for the application context. 
The @RequiredArgsConstructor annotation generates a constructor with required parameters. 
The userDetailsService() method creates an instance of UserDetailsService, which is used to look up user information from the repository. 
The authenticationProvider() method creates an instance of DaoAuthenticationProvider, which is used to authenticate users with their credentials. 
The authenticationManager() method creates an instance of AuthenticationManager, which is used to manage authentication requests. 
Finally, the passwordEncoder() method creates an instance of BCryptPasswordEncoder, which is used to encode passwords for storage in the repository.
*/

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository repository;

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> repository.findByEmail(username)
                .orElseThrow(() ->new UsernameNotFoundException("User not Found"));
    }

    @Bean
    public AuthenticationProvider  authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
        }


@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
