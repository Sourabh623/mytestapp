package com.mytestapp.repository;

import com.mytestapp.StringUtils;
import com.mytestapp.model.Person;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void is_Person_ExistById() {
        //actual result
        Boolean actualResult = this.personRepository.isPersonExistById(1);

        //expected is true
        //Assertions.assertThat(actualResult).isTrue();
        assertEquals(true,actualResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void testFindPersonNameByPersonId(Integer input, String expected){
        Optional<Person> actualResult = this.personRepository.findPersonNameByPersonId(input);
        assertEquals(expected,actualResult.get().getPersonName());
    }
}