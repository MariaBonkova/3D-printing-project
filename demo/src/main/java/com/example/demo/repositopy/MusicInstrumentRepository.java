package com.example.demo.repositopy;

import com.example.demo.models.entity.MusicalInstrumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicInstrumentRepository extends JpaRepository<MusicalInstrumentEntity, Long> {
}
