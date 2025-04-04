package com.example.demo.controller;

import com.example.demo.jpa.entity.CategorieEntity;
import com.example.demo.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/all")
    public List<CategorieEntity> getAllGategories(){
        return categorieService.getAllCategories();
    }

    @GetMapping("/byName/{name}")
    public Optional<CategorieEntity> getGategorieByName(@PathVariable String name){
        return categorieService.getCategorieByNom(name);
    }
    @PostMapping("/add")
    public CategorieEntity AjoutCategorie(@RequestBody CategorieEntity categorieEntity){
        return categorieService.ajouterCategorie(categorieEntity);
    }

}
