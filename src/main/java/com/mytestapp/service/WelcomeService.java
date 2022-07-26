package com.mytestapp.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String getMessage(){
        return "welcome to home";
    }

}
