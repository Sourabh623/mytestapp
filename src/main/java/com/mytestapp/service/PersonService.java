package com.mytestapp.service;

import com.mytestapp.model.Person;
import com.mytestapp.repository.PersonRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    //get all person
    public List<Person> getAllPerson(){
        return this.personRepository.findAll();
    }

    //create a person
    public Person createPerson(Person person){
        Person person1 = new Person();
        person1.setPersonId(person.getPersonId());
        person1.setPersonName(person.getPersonName());
        person1.setPersonCity(person.getPersonCity());
        return this.personRepository.save(person1);
    }

    public String getNameById(Integer personId){
        Optional<Person> person = Optional.of(this.personRepository.findPersonNameByPersonId(personId).get());
        if(person==null) return null;
        return person.map(Person::getPersonName).orElse(null);
    }

    //private method
    private String getCityById(Integer personId){
        Optional<Person> person = this.personRepository.findById(personId);
        return person.get().getPersonCity();
    }

    //for testing fake repo initialization
    public PersonService(PersonRepository personRepository1){
        this.personRepository = personRepository1;
    }


}
