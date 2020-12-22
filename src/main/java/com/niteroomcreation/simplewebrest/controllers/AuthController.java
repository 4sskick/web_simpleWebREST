package com.niteroomcreation.simplewebrest.controllers;

import com.niteroomcreation.simplewebrest.models.data.domains.User;
import com.niteroomcreation.simplewebrest.models.data.repositories.UserRepository;
import com.niteroomcreation.simplewebrest.models.data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by monta on 22/12/20
 * please make sure to use credit when you're using people's code
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/login"
            , method = RequestMethod.POST
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public void login(@RequestBody User model) {

    }

    @RequestMapping(value = "/register"
            , method = RequestMethod.POST
            , headers = {"Accept=application/json"}
            , produces = MediaType.APPLICATION_JSON_VALUE)
    public void register(@RequestBody User model) {
        service.save(model);
    }
}
