package com.niteroomcreation.simplewebrest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by monta on 02/12/20
 * please make sure to use credit when you're using people's code
 */

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping("/greeting")
    public ResponseEntity<String> get(){
        return ResponseEntity.ok("Hello from java Spring Web");
    }
}
