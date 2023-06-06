package com.example.login.Repository;

import com.example.login.Entity.User.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//interface for crud operations
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
