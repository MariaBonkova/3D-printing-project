package com.example.demo.repositopy;

import com.example.demo.models.entity.MaterialEntity;
import com.example.demo.models.entity.enums.MaterialComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MaterialRepository extends JpaRepository<MaterialEntity,Long> {
    void findByName(MaterialComposition materialComposition);

    @Query("select m.price from MaterialEntity as m where m.name like :name")
    BigDecimal findMaterialEntitiesByPrice(@Param("name") String name);
}
