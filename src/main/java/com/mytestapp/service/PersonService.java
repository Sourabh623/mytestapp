package com.mytestapp.service;

import com.mytestapp.model.Person;
import com.mytestapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    //get all person
    public List<Person> getAllPerson(){
        return this.personRepository.findAll();
    }

    //for testing fake repo initialization
    public PersonService(PersonRepository personRepository1){
        this.personRepository = personRepository1;
    }


}
