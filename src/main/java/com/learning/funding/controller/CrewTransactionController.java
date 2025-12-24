package com.learning.funding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.funding.entity.CrewTransaction;
import com.learning.funding.service.CrewTransactionService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/transactions")
public class CrewTransactionController {
    private CrewTransactionService crewTransactionService;

    public CrewTransactionController(CrewTransactionService crewTransactionService){
        this.crewTransactionService=crewTransactionService;
    }

    @GetMapping()
    public List<CrewTransaction> getAllTransactions() {
        return crewTransactionService.getAllCrewTransactions();
    }

    @GetMapping("/{crewId}")
    public List<CrewTransaction> getTransactionsById(@PathVariable Long crewId) {
        return crewTransactionService.getTransactionsById(crewId);
    }
    
    
}
