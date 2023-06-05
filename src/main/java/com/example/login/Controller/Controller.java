package com.example.login.Controller;

import com.example.login.Model.Person;
import com.example.login.Service.PersonService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class Controller {
    PersonService personService;

    public Controller(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> person = personService.getPerson();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of person as response
    @GetMapping({"/{PersonId}"})
    public ResponseEntity<Person> getPerson(@PathVariable Long PersonId) {
        return new ResponseEntity<>(personService.getPersonById(PersonId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Todo and saves it to the database, and returns a resource link to the created todo.           @PostMapping
    public ResponseEntity<Person> saveTodo(@RequestBody Person person) {
        Person person1 = personService.insert(person);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("person", "/person/" + person1.getId());
        return new ResponseEntity<>(person1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Todo with the specified Id and returns the updated Todo
    @PutMapping({"/{PersonId}"})
    public ResponseEntity<Person> updateTodo(@PathVariable("PersonId") Long PersonId, @RequestBody Person person) {
        personService.updatePerson(PersonId,person);
        return new ResponseEntity<>(personService.getPersonById(PersonId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Todo with the specified Id.
    @DeleteMapping({"/{PersonId}"})
    public ResponseEntity<Person> deleteTodo(@PathVariable("personId") Long PersonId) {
        personService.DeletePerson(PersonId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
