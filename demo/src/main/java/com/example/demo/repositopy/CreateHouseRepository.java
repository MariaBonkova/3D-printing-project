package com.example.demo.repositopy;

import com.example.demo.models.entity.CreateHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CreateHouseRepository extends JpaRepository<CreateHouseEntity,Long> {

    BigDecimal findByFlat(BigDecimal flat);
}
