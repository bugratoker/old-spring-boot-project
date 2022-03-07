package com.tokerbugra.project.dto;

import com.tokerbugra.project.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class TransactionDto {
    private String id;
    private TransactionType transactionType=TransactionType.INITIAL;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    public TransactionDto(String id, TransactionType transactionType,
                          BigDecimal amount, LocalDateTime transactionDate) {

        this.id=id;
        this.transactionType=transactionType;
        this.amount=amount;
        this.transactionDate=transactionDate;
    }
}
