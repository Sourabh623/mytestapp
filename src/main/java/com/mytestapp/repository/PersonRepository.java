package com.mytestapp.repository;

import com.mytestapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId = ?1")
    Boolean isPersonExistById(Integer personId);

    Optional<Person> findPersonNameByPersonId(Integer personId);

    Optional<Person> findPersonCityByPersonId(Integer personId);

    //@Query("SELECT*FROM person ORDER BY person.person_id DESC")
    @Query("from Person as per order by per.personId desc")
    List<Person> personIdOrderByDesc();

    @Query("from Person as per order by per.personName" +
            " desc")
    List<Person> personNameOrderByDesc();
}
