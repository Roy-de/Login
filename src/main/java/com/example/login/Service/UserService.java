package com.example.login.Service;

import com.example.login.Entity.Data.UserData;

public interface UserService {
    void Register(UserData userdata)throws Exception;

    boolean checkifUserExists(String email);
}
