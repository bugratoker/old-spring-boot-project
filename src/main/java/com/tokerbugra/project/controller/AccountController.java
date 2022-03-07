package com.tokerbugra.project.controller;

import com.tokerbugra.project.dto.AccountDto;
import com.tokerbugra.project.dto.CreateAccountRequest;
import com.tokerbugra.project.model.Account;
import com.tokerbugra.project.model.Customer;
import com.tokerbugra.project.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/account")

public class AccountController {

    private final AccountService accountService;



    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Account>> findAll(){

        return ResponseEntity.ok(accountService.getAll());
    }


    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request){

        return ResponseEntity.ok(accountService.createAccount(request));


    }
}

