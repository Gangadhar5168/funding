package com.learning.funding.dto;

import java.math.BigDecimal;

public class UpdateCrewRequestDto {
     private String crewName;

    private String pin;

    private BigDecimal limitAmount;

    private BigDecimal balance;

    private Boolean active;

    public UpdateCrewRequestDto(){

    }
    public UpdateCrewRequestDto(String crewName, String pin, BigDecimal limitAmount, BigDecimal balance,
            boolean active) {
        this.crewName = crewName;
        this.pin = pin;
        this.limitAmount = limitAmount;
        this.balance = balance;
        this.active = active;
    }
    public String getCrewName() {
        return crewName;
    }
    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public BigDecimal getLimitAmount() {
        return limitAmount;
    }
    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Boolean isActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
}
