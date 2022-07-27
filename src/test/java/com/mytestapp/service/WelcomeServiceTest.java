package com.mytestapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class WelcomeServiceTest {
    @Autowired
    private WelcomeService welcomeService;

    @Test
    void getMessage() {
        String message = this.welcomeService.getMessage();
        assertEquals("welcome to home",message);
    }
}