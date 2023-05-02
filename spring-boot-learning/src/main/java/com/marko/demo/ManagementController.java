package com.marko.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
This code is a Java class that creates an endpoint for a REST API.
The class contains one method, sayHello(), which is annotated with @GetMapping
and returns a ResponseEntity containing the string "Hello from secured endpoint".
*/

@RestController
@RequestMapping("/api/v1/management")
public class ManagementController {

    @GetMapping
    public String get() {
        return "GET:: management controller";
    }

    @PostMapping
    public String post() {
        return "POST:: management controller";
    }

    @PutMapping
    public String put() {
        return "PUT:: management controller";
    }

    @DeleteMapping
    public String delete() {
        return "DELETE:: management controller";
    }
}
