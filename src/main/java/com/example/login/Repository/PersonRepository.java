package com.example.login.Repository;

import com.example.login.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
/*    default List<Person> findByFirst_name(String first_name) {
        return null;
    }
    Person findById(long id);*/
}
