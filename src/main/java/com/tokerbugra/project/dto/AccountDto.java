package com.tokerbugra.project.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class AccountDto {

    private String id;
    private BigDecimal balance;
    private LocalDateTime localDateTime;
    private CustomerDto customer;
    private Set<TransactionDto> transactions;

    public AccountDto(String id, CustomerDto customer,BigDecimal balance, LocalDateTime localDateTime, Set<TransactionDto> transactions) {

        this.id = id;
        this.customer = customer;
        this.balance = balance;
        this.localDateTime = localDateTime;
        this.transactions=transactions;

    }
}
