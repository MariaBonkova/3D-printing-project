package com.example.demo.repositopy;

import com.example.demo.models.entity.HouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HouseEntity, Long> {
}
