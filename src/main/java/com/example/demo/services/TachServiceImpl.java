package com.example.demo.services;


import com.example.demo.exception.TacheNotFoundException;
import com.example.demo.jpa.entity.TacheEntity;
import com.example.demo.jpa.repository.TachRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TachServiceImpl implements TachService{

    @Autowired
    private TachRepository repository;

    @Override
    public TacheEntity creeTache(TacheEntity tache) {
        return repository.save(tache);
    }

    @Override
    public List<TacheEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public TacheEntity getById(Long id) {
        return repository.findById(id)
                .orElseThrow(()->new TacheNotFoundException(id));
    }

    @Override
    public TacheEntity updateTache(Long id, TacheEntity tache) {
        TacheEntity existante = getById(id);
        existante.setTitle(tache.getTitle());
        existante.setDescription(tache.getDescription());
        existante.setEtatTach(tache.getEtatTach());
        return repository.save(existante);
    }

    @Override
    public void deleteTache(Long id) {
        repository.deleteById(id);
    }
}
