package com.tokerbugra.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id ="";
    private BigDecimal balance = BigDecimal.ZERO;
    private LocalDateTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY) // mappedBy = account çünkü transactionda account fieldı var
    private Set<Transaction> transaction=new HashSet<>();

    public Account(Customer customer, BigDecimal initialCredit, LocalDateTime now) {
        this.customer=customer;
        this.balance=initialCredit;
        this.localDateTime = now;
    }
}
