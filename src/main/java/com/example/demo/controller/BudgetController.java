package com.example.demo.controller;


import com.example.demo.jpa.entity.RevenuEntity;
import com.example.demo.jpa.repository.RevenuRepos;
import com.example.demo.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/budget")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private RevenuRepos revenuRepos;

    @PostMapping("/add")
    public ResponseEntity<RevenuEntity> ajoutRevenu(@RequestBody RevenuEntity revenu){
         var reve = revenuRepos.save(revenu);
         return ResponseEntity.ok(reve);
    }
    @GetMapping("/solde")
    public double getSolde(){
        return budgetService.getSoldeRestant();
    }

    @GetMapping("/all")
    public double getRevenue(){
        return budgetService.getTotalRevenu();
    }

}
