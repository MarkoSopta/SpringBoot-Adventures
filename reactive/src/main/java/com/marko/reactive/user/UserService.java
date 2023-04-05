package com.marko.reactive.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public Mono<User> save(User user)  {
       return userRepo.save(user);
    }

    public Flux<User> findAll(){
        return userRepo.findAll()
                .delayElements(Duration.ofSeconds(2));
    }
    public Mono<User> findById(Integer id){
        return userRepo.findById(id);
    }
}
