package com.example.demo.repositopy;

import com.example.demo.models.entity.PetsItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsItemRepository extends JpaRepository<PetsItemEntity, Long> {

}
