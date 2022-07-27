package com.mytestapp.controller;

import com.mytestapp.model.Person;
import com.mytestapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    //create a person
    @PostMapping(value = "/person", consumes = "application/json")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person savePerson = this.personService.createPerson(person);
        return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
    }

    //get person name by id
    @GetMapping("/person/{personId}")
    public String getPersonNameById(@PathVariable Integer personId){
        String name = this.personService.getNameById(personId);
        return name;
    }

    //get all persons
    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.ok(this.personService.getAllPerson());
    }

    @GetMapping("/orderByDescPerson")
    public ResponseEntity<List<Person>> orderByDescPersonList(){
        return ResponseEntity.ok(this.personService.orderByDescPersonList());
    }
    @GetMapping("/orderByDescPersonUsingName")
    public ResponseEntity<List<Person>> orderByDescPersonListUsingName(){
        return ResponseEntity.ok(this.personService.orderByDescPersonListUsingName());
    }
}
