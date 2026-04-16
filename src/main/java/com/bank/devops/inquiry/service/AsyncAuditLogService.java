package com.bank.devops.inquiry.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncAuditLogService {

    @Async
    public void logInquiryHit(String accountNo) {
        String threadName = Thread.currentThread().getName();
        System.out.printf(
            "[AUDIT] inquiry hit | accountNo=%s | timestamp=%s | thread=%s%n",
            accountNo,
            LocalDateTime.now(),
            threadName
        );
    }

    @Async
    public void runCpuSimulation(String accountNo) {
        BigDecimal accumulator = BigDecimal.ONE;
        for (int i = 1; i <= 10_000; i++) {
            accumulator = accumulator.multiply(BigDecimal.valueOf(1.0001));
            if (accumulator.precision() > 40) {
                accumulator = accumulator.round(MathContext.DECIMAL64);
            }
        }

        System.out.printf(
            "[SIMULATION] cpu task done | accountNo=%s | result=%s | thread=%s%n",
            accountNo,
            accumulator.toPlainString(),
            Thread.currentThread().getName()
        );
    }
}
