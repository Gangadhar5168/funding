package com.learning.funding.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.funding.entity.CrewTransaction;
import com.learning.funding.repository.CrewTransactionRepository;

@Service
public class CrewTransactionService {
    private CrewTransactionRepository crewTransactionRepository;

    public CrewTransactionService(CrewTransactionRepository crewTransactionRepository){
        this.crewTransactionRepository = crewTransactionRepository;
    }

    public List<CrewTransaction> getAllCrewTransactions(){
        return crewTransactionRepository.findAll();
    }

    public List<CrewTransaction> getTransactionsById(Long crewId){
        List<CrewTransaction> transactions = crewTransactionRepository.findByCrewId(crewId)
                                        .orElseThrow(()-> new RuntimeException("Transaction not found"));
        return transactions;

    }
}
