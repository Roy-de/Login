package com.example.login.Entity.Data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserData {
    private int id;
    private String Name;
    private String Password;
    private String Email;

    public UserData(String name, String password, String email) {
        Name = name;
        Password = password;
        Email = email;
    }
}
