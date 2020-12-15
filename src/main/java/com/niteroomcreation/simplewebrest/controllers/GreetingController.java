package com.niteroomcreation.simplewebrest.controllers;

import com.niteroomcreation.simplewebrest.models.data.domains.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by monta on 02/12/20
 * please make sure to use credit when you're using people's code
 */

@RestController
@RequestMapping("/api")
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Hello from java Spring Web");
    }

    //would returning as JSON content
    //default is using Jackson 2 to be parsed
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "USER") String name) {
        return new Greeting(counter.incrementAndGet(), String.format("Hello %s, welcome to java Spring Web", name));
    }
}
