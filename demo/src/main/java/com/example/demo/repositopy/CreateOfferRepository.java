package com.example.demo.repositopy;

import com.example.demo.models.entity.CreateHouseEntity;
import com.example.demo.models.entity.CreateOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CreateOfferRepository extends JpaRepository<CreateOfferEntity,Long> {

    Optional<CreateOfferEntity>findById(Long id);









}
