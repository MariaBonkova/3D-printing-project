package com.example.demo.repositopy;

import com.example.demo.models.entity.UserEntity;
import com.example.demo.service.ApplicationUserDetailsService;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity>findByEmail(String email);

    Optional<UserEntity>findByUserName(String userName);

    Optional<UserEntity> findUserEntityByUserName(String username);

    boolean existsByEmail(String email);
}
