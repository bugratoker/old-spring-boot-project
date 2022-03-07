package com.tokerbugra.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private String surname;
    //mappedBy ?????
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private Set<Account> accounts;

    public Customer(String name,String surname) {
        this.name=name;
        this.surname=surname;

    }

    public Customer() {

    }
}
