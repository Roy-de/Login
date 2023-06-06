package com.example.login.Entity.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name="User_Details")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true,nullable = false,name = "id")
    private int id ;
    @Column(nullable = false,name = "Name")
    private String Name;
    @Column(nullable = false,unique = true,name = "Email")
    private String email;
    @Column(nullable = false,name = "Password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private Collection<RoleEntity> roles;
    public UserEntity(String name, String email, String password, Collection<RoleEntity> roles) {
        Name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
