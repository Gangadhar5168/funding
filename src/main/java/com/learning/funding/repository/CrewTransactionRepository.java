package com.learning.funding.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.funding.entity.CrewTransaction;

public interface CrewTransactionRepository extends JpaRepository<CrewTransaction,Long>{
    Optional<List<CrewTransaction>> findByCrewId(Long crewId);
}
