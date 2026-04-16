package com.bank.devops.inquiry.controller;

import com.bank.devops.inquiry.model.InquiryResponse;
import com.bank.devops.inquiry.service.AsyncAuditLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class InquiryController {

    private final AsyncAuditLogService asyncAuditLogService;

    public InquiryController(AsyncAuditLogService asyncAuditLogService) {
        this.asyncAuditLogService = asyncAuditLogService;
    }

    @GetMapping("/api/v1/inquiry/{accountNo}")
    public InquiryResponse inquiry(@PathVariable String accountNo) {
        // Trigger async logging + CPU simulation in background thread
        // so request thread can return response faster.
        asyncAuditLogService.logInquiryHit(accountNo);
        asyncAuditLogService.runCpuSimulation(accountNo);

        return new InquiryResponse(
                accountNo,
                new BigDecimal("1500000.00"),
                "IDR",
                "SUCCESS",
                "Mock balance returned successfully"
        );
    }
}
