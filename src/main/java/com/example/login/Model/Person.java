package com.example.login.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,length = 20)
    private String first_name;
    @Column(nullable = false,length = 20)
    private String last_name;
    //Return String
    @Override
    public String toString(){
        return "First Name:" + first_name + " Last Name: " + last_name;
    }
}
