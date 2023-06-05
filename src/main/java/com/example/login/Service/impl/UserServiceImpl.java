package com.example.login.Service.impl;

import com.example.login.Entity.Data.UserData;
import com.example.login.Entity.User.UserEntity;
import com.example.login.Repository.UserRepository;
import com.example.login.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void Register(UserData userdata)throws Exception{
        if(checkifUserExists(userdata.getEmail())){
            throw new Exception("UserEntity Already Exists");
        }
    }
    @Override
    public boolean checkifUserExists(String email) {
        if (userRepository.findByEmail(email)) return true;
        else return false;
    }
    private void encodePassword(UserEntity userEntity, UserData userdata){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    }
}
