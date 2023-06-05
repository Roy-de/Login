package com.example.login.Repository;

import com.example.login.Entity.User.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//This JPA is used to save the user info
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean findByEmail(String email);
}
