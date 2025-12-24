package com.learning.funding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.funding.entity.Crew;

public interface CrewRepository extends JpaRepository<Crew,Long>{
    
}
