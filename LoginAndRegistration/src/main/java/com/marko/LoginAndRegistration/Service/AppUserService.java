package com.marko.LoginAndRegistration.Service;


import com.marko.LoginAndRegistration.AppUser.AppUser;
import com.marko.LoginAndRegistration.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final BCryptPasswordEncoder encoder;
    private final UserRepository repository;

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
        // TODO:Send confirm token
        return "it werke";
    }
}
