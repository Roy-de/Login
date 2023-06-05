package com.example.login.Entity.Data;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class UserData implements Serializable {
    private int id;
    @Nonnull
    private String Name;
    private String Password;
    private String Email;
}
