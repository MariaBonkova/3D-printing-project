package com.example.demo.web;

import com.example.demo.service.HouseCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CatalogsController {
    private final HouseCatalogService houseCatalogService;

    public CatalogsController(HouseCatalogService houseCatalogService) {
        this.houseCatalogService = houseCatalogService;
    }

    @GetMapping("/house-catalog/delete/{id}")
    public String houseCatalog(@PathVariable  Long id){
        houseCatalogService.deleteOffer(id);
        return "/house-catalog";

    } @GetMapping("/music-catalog/delete/{id}")
    public String musicCatalog(@PathVariable  Long id){
        houseCatalogService.deleteOffer(id);
        return "/music-catalog";

    } @GetMapping("/pets-catalog/delete/{id}")
    public String petsCatalog(@PathVariable  Long id){
        houseCatalogService.deleteOffer(id);
        return "/pets-catalog";

    }
}
