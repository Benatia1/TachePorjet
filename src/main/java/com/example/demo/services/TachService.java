package com.example.demo.services;

import com.example.demo.jpa.entity.TacheEntity;

import java.util.List;

public interface TachService {
    TacheEntity creeTache(TacheEntity tache);
    List<TacheEntity> getAll();
    TacheEntity getById(Long id);
    TacheEntity updateTache(Long id, TacheEntity tache);
    void deleteTache(Long id);
}
