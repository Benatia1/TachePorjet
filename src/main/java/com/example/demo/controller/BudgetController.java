package com.example.demo.controller;


import com.example.demo.jpa.entity.RevenuEntity;
import com.example.demo.jpa.repository.RevenuRepos;
import com.example.demo.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private RevenuRepos revenuRepos;

    @PostMapping
    public ResponseEntity<RevenuEntity> ajoutRevenu(@RequestBody RevenuEntity revenu){
         var reve = revenuRepos.save(revenu);
         return ResponseEntity.ok(reve);
    }
}
