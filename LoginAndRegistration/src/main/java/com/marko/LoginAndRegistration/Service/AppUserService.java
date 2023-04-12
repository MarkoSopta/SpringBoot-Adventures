package com.marko.LoginAndRegistration.Service;


import com.marko.LoginAndRegistration.AppUser.AppUser;
import com.marko.LoginAndRegistration.Registration.token.ConfirmationToken;
import com.marko.LoginAndRegistration.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository repository;
    private final ConfirmationTokenService cservice;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username does not exist"));
    }

    public String signUpUser(AppUser appUser) {
        boolean exists = repository.findByEmail(appUser.getEmail())
                .isPresent();
        if (exists) {
            throw new IllegalStateException("Email already taken");
        }
        String encodedPassword = encoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        repository.save(appUser);
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                appUser
        );

        //TODO: send email
        cservice.saveConfirmationToken(confirmToken);
        return token;
    }

    public int enableAppUser(String email) {
        return repository.enableAppUser(email);
    }
}
