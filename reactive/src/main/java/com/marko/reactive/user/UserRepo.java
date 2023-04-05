package com.marko.reactive.user;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepo extends ReactiveCrudRepository<User,Integer> {

    Mono<User> findUserByfirstname(String firstname);
}
