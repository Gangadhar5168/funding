package com.learning.funding.dto;

import java.math.BigDecimal;

public class ReturnRequestDto {

    private String pin;
    private BigDecimal amount;
    
    public ReturnRequestDto(){

    }

    public ReturnRequestDto(String pin, BigDecimal amount) {
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
