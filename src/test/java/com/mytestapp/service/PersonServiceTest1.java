package com.mytestapp.service;

import com.mytestapp.model.Person;
import com.mytestapp.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static  org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class PersonServiceTest1 {

    @MockBean
    PersonRepository mockPersonRepositoryBean;

    @Test
    void testGetNameById(){

        //create a mock data for service layer testing functionality
        Optional<Person> person = Optional.of(new Person(101,"nick","indore"));
        when(mockPersonRepositoryBean.findPersonNameByPersonId(101)).thenReturn(person);

        //isolated component testing
        //inject the mock bean into the service layer
        PersonService personService = new PersonService(mockPersonRepositoryBean);
        String actualResult = personService.getNameById(101);

        //check
        Assertions.assertEquals(actualResult,"nick");
    }

    @Test
    void testGetCityById(){
        //create a mock data for service layer testing functionality
        Optional<Person> person = Optional.of(new Person(101,"nick","indore"));
        when(mockPersonRepositoryBean.findPersonCityByPersonId(101)).thenReturn(person);

        //isolated component testing
        //inject the mock bean into the service layer
        PersonService personService = new PersonService(mockPersonRepositoryBean);
        String actualResult = personService.getCityById(101);

        //check
        Assertions.assertEquals(actualResult,"indore");
    }
}