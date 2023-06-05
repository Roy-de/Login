package com.example.login.Service;

import com.example.login.Model.Person;
import com.example.login.Repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PersonServiceImpl implements PersonService{
    PersonRepository personRepository;
    @Override
    public List<Person> getPerson() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll().forEach((Consumer<? super Person>) persons::add);
        return persons;
    }

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(Long id) {
    return personRepository.findById(id).get();
    }

    @Override
    public Person insert(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person personUpdate = personRepository.findById(id).get();
        System.out.println(personUpdate.toString());
        personUpdate.setFirst_name(person.getFirst_name());
        personUpdate.setLast_name(person.getLast_name());
        personRepository.save(personUpdate);
    }

    @Override
    public void DeletePerson(Long Personid) {
        personRepository.deleteById(Personid);
    }
}
