package com.example.demo.controller;

import com.example.demo.jpa.entity.TacheEntity;
import com.example.demo.jpa.repository.TachRepository;
import com.example.demo.services.EtatTach;
import com.example.demo.services.EtatTachDto;
import com.example.demo.services.TachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TachController {
    @Autowired
    public TachService service;
    @Autowired
    public TachRepository repository;

    @PostMapping("/addTache")
    public ResponseEntity<TacheEntity> AddTache(@RequestBody TacheEntity tache){
        return ResponseEntity.ok(service.creeTache(tache));
    }
//Ajouter une requête pour avoir les tâche par état
    @GetMapping("/allTache")
    public List<TacheEntity> getAllTache(){
        return service.getAll();
    }

    @GetMapping("tachById/{id}")
    public TacheEntity getTacheById(@PathVariable Long id){
        return service.getById(id);
    }

    @PutMapping("modifTache/{id}")
    public ResponseEntity<TacheEntity> modifyTache(@PathVariable Long id, @RequestBody TacheEntity tache){
        return ResponseEntity.ok(service.updateTache(id, tache));
    }
    @PatchMapping("/{id}/etat")
    public ResponseEntity<TacheEntity> patchEtat(@PathVariable Long id, @RequestBody EtatTachDto dto) {
        TacheEntity existante = service.getById(id);
        existante.setEtatTach(dto.getEtatTach());
        return ResponseEntity.ok(repository.save(existante));
    }


    @DeleteMapping("deleteTache/{id}")
    public void deleteTache(@PathVariable Long id){
        service.deleteTache(id);
    }
}
