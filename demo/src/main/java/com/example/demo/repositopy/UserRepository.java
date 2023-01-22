package com.example.demo.repositopy;

import com.example.demo.models.entity.Home;
import com.example.demo.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
