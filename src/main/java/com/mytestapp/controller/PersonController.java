package com.mytestapp.controller;

import com.mytestapp.model.Person;
import com.mytestapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;


    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(this.personService.getAllPerson());
    }
}
