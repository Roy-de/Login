package com.example.login.Service;

import com.example.login.Entity.Data.UserData;
import com.example.login.Entity.User.UserEntity;

public interface UserService {
    UserEntity Register(UserData userdata);

}
