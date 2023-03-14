package com.marko.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
This code is a Java class that creates an endpoint for a REST API.
The class contains one method, sayHello(), which is annotated with @GetMapping 
and returns a ResponseEntity containing the string "Hello from secured endpoint".
*/

@RestController
@RequestMapping("/api/v1/democontroller")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> sayHello()
    {
        return ResponseEntity.ok("Hello from secured endpoint");
    }
}
