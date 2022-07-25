package com.mytestapp.service;

import com.mytestapp.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @MockBean
    PersonRepository personRepository;
    private PersonService personService;

    @BeforeEach
    void setUp() {
        this.personService=new PersonService(this.personRepository);
    }

    @Test
    void getAllPerson() {
        personService.getAllPerson();
        Mockito.verify(this.personRepository).findAll();
    }
}