package com.tokerbugra.project.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private TransactionType transactionType = TransactionType.INITIAL;

    private BigDecimal amount;
    private LocalDateTime transactionDate;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    public Transaction(BigDecimal amount,Account account) {
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.account = account;
    }

    public Transaction() {

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
