package com.learning.funding.dto;

import java.math.BigDecimal;

public class AdvanceRequestDto {

    private String pin;
    private BigDecimal amount;

    public AdvanceRequestDto(){

    }

    
    public AdvanceRequestDto(String pin, BigDecimal amount) {
        this.pin = pin;
        this.amount = amount;
    }


    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    
}
