package com.example.demo.controller;

import com.example.demo.jpa.entity.DepensesEntity;
import com.example.demo.jpa.repository.CategorieRepository;
import com.example.demo.jpa.repository.DepenseRepo;
import com.example.demo.services.CategorieService;
import com.example.demo.services.DepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/depense")
public class DepenseController {

    @Autowired
    private DepenseService depenseService;
    @Autowired
    private CategorieService categorieService;


    @PostMapping("/add")
    public DepensesEntity addDepense(@RequestBody DepensesEntity depenses) {
        return depenseService.ajoutDepence(depenses);
    }

    @GetMapping("/all")
    public List<DepensesEntity> allDepenses() {
        return depenseService.getAllDepence();
    }

    @GetMapping("/byNom/{nom}")
    public DepensesEntity byNom(@PathVariable String nom) {
        return depenseService.getDepencesByNom(nom)
                .orElseThrow(() -> new RuntimeException("depense avec le nom" + nom + "nom trouvé"));
    }

    @GetMapping("/byCatg/{categorie}")
    public List<DepensesEntity> byCategorie(@PathVariable String categorie) {
       return categorieService.getDespenseByCategorie(categorie);
    }}

