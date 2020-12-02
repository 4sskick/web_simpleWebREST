package com.niteroomcreation.simplewebrest;

import com.niteroomcreation.simplewebrest.controllers.GreetingController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleWebRestApplicationTests {

    @Autowired
    private GreetingController greetingController;

    @Test
    void contextLoads() {
        Assertions.assertTrue(greetingController != null);
    }

}
