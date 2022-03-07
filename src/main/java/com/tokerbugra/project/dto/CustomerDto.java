package com.tokerbugra.project.dto;

import com.tokerbugra.project.model.Account;

import java.util.Set;

public class CustomerDto {

    private String id;
    private String name;
    private String surname;
    private Set<AccountDto> accounts;


    public CustomerDto(String id, String name, String surname, Set<AccountDto> accounts) {
        this.id=id;
        this.name=name;
        this.surname=surname;
        this.accounts=accounts;
    }

    public CustomerDto(String id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
