package com.marko.LoginAndRegistration.Service;

import com.marko.LoginAndRegistration.AppUser.AppUser;
import com.marko.LoginAndRegistration.AppUser.AppUserRole;
import com.marko.LoginAndRegistration.Registration.EmailValidator;
import com.marko.LoginAndRegistration.Registration.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("Email not Valid");
        }
        return appUserService.signUpUser(new AppUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                AppUserRole.USER

        ));
    }
}
