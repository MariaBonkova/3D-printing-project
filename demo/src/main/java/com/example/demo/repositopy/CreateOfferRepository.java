package com.example.demo.repositopy;

import com.example.demo.models.entity.CreateOfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreateOfferRepository extends JpaRepository<CreateOfferEntity,Long> {

}
