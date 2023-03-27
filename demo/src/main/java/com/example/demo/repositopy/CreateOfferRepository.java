package com.example.demo.repositopy;

import com.example.demo.models.entity.CreateOfferEntity;
import com.example.demo.models.view.CreateOfferView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CreateOfferRepository extends JpaRepository<CreateOfferEntity,Long> {

    Optional<CreateOfferEntity>findByProductName(String productName);


}
