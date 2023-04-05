package com.marko.reactive.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    Mono<User> save(
            @RequestBody User user) {
        return userService.save(user);
    }
    @GetMapping
    Flux<User> findAll (){

        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User>findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }
}
