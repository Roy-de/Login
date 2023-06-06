package com.example.login.Entity.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public RoleEntity(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;

    public RoleEntity() {
        
    }
}
