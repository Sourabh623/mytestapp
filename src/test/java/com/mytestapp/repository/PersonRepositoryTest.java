package com.mytestapp.repository;

import com.mytestapp.model.Person;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void is_Person_ExistById() {
        
        Person person = new Person(3,"abhi","indore");
        Person savePerson = this.personRepository.save(person);

        //expected
        //Integer personId = 1;

        //actual result
        Boolean actualResult = this.personRepository.isPersonExistById(savePerson.getPersonId());

        //expected is true
        //Assertions.assertThat(actualResult).isTrue();
        assertEquals(true,actualResult);
    }

    @AfterEach
    void tearDown() {
        System.out.println("this method run after test cases");
        personRepository.deleteAll();
    }
}