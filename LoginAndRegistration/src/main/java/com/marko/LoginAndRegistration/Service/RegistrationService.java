package com.marko.LoginAndRegistration.Service;

import com.marko.LoginAndRegistration.Registration.RegistrationRequest;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
    public String register (RegistrationRequest request){
        return "works";
    }
}
