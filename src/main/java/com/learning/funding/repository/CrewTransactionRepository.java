package com.learning.funding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.funding.entity.CrewTransaction;

public interface CrewTransactionRepository extends JpaRepository<CrewTransaction,Long>{
    
}
