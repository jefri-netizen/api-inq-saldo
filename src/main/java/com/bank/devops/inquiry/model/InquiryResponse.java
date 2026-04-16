package com.bank.devops.inquiry.model;

import java.math.BigDecimal;

public class InquiryResponse {

    private String accountNo;
    private BigDecimal balance;
    private String currency;
    private String status;
    private String message;

    public InquiryResponse() {
    }

    public InquiryResponse(String accountNo, BigDecimal balance, String currency, String status, String message) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
        this.message = message;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
