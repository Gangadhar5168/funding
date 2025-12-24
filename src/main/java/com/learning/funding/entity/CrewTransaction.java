package com.learning.funding.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CrewTransaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Long crewId;

    private String crewName;

    private BigDecimal amount;

    private LocalDateTime transactionTime;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    public CrewTransaction(){
        
    }

    public CrewTransaction(Long crewId, String crewName, BigDecimal amount, LocalDateTime transactionTime,
            TransactionType type) {
        this.crewId = crewId;
        this.crewName = crewName;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.type = type;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getCrewId() {
        return crewId;
    }

    public void setCrewId(Long crewId) {
        this.crewId = crewId;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
    
}
