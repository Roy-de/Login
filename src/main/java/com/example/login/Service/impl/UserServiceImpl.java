package com.example.login.Service.impl;

import com.example.login.Entity.Data.UserData;
import com.example.login.Entity.User.RoleEntity;
import com.example.login.Entity.User.UserEntity;
import com.example.login.Repository.UserRepository;
import com.example.login.Service.UserService;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

/*
    private void encodePassword(UserEntity userEntity, UserData userdata){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    }
*/

    @Override
    /* Save user registration data to database */
    public UserEntity Register(UserData userdata){
        UserEntity user = new UserEntity(
                userdata.getName(),
                userdata.getEmail(),
                userdata.getPassword(),
                List.of(new RoleEntity("USER")));
        return  userRepository.save(user);
    }
}
