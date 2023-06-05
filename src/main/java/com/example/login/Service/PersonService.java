package com.example.login.Service;

import com.example.login.Model.Person;

import java.util.List;

public interface PersonService {
    default List<Person> getPerson() {
        return null;
    }
    Person getPersonById(Long id);
    Person insert(Person person);
    void updatePerson(Long id, Person person);
    void DeletePerson(Long Personid);
}
