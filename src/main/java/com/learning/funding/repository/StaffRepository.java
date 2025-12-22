package com.learning.funding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.funding.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer>{
    
}
