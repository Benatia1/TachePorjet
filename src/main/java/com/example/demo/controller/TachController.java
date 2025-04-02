package com.example.demo.controller;

import com.example.demo.jpa.entity.TacheEntity;
import com.example.demo.services.TachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TachController {
    @Autowired
    public TachService service;

    @PostMapping("/addTache")
    public ResponseEntity<TacheEntity> AddTache(@RequestBody TacheEntity tache){
        return ResponseEntity.ok(service.creeTache(tache));
    }

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

    @DeleteMapping("deleteTache/{id}")
    public void deleteTache(@PathVariable Long id){
        service.deleteTache(id);
    }
}
