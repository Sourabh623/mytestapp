package com.mytestapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private Integer personId;
    private String personName;
    private String personCity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "person_roles", joinColumns = @JoinColumn(name = "personId", referencedColumnName = "personId"), inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
    @JsonIgnore
    Set<Role> roles = new HashSet<>();

    public Person(Integer personId, String personName, String personCity) {
        this.personId = personId;
        this.personName = personName;
        this.personCity = personCity;
    }
}
