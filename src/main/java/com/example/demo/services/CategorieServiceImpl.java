package com.example.demo.services;

import com.example.demo.jpa.entity.CategorieEntity;
import com.example.demo.jpa.entity.DepensesEntity;
import com.example.demo.jpa.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private DepenseService depenseService;
    @Override
    public CategorieEntity ajouterCategorie(CategorieEntity categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public List<CategorieEntity> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Optional<CategorieEntity> getCategorieByNom(String nom) {
        return Optional.ofNullable(categorieRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Categorie avec ce nom " + nom + "n'est pas trouvé")));
    }

    @Override
    public List<DepensesEntity> getDespenseByCategorie(String nom) {
        var cat = categorieRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
        var depensesParCategorie = depenseService.getAllDepence().stream()
                .filter(d -> d.getCategorie() != null && d.getCategorie().getNom().equals(cat.getNom())).collect(Collectors.toList());
        if(depensesParCategorie.isEmpty()){
            throw new RuntimeException("Aucune dépense liée à cette catégorie");
        }
        return depensesParCategorie;
    }
}
