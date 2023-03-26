package com.example.demo.service.impl;

import com.example.demo.repositopy.HouseCatalogRepository;
import com.example.demo.service.HouseCatalogService;
import org.springframework.stereotype.Service;

@Service
public class HouseCatalogServiceImpl implements HouseCatalogService {

private final HouseCatalogRepository houseCatalogRepository;

    public HouseCatalogServiceImpl(HouseCatalogRepository houseCatalogRepository) {
        this.houseCatalogRepository = houseCatalogRepository;
    }


    @Override
    public void deleteOffer(Long id) {
        houseCatalogRepository.deleteById(id);
    }
}
