package com.tokerbugra.project.service;

import com.tokerbugra.project.dto.*;
import com.tokerbugra.project.model.Account;
import com.tokerbugra.project.model.Customer;
import com.tokerbugra.project.model.Transaction;
import com.tokerbugra.project.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;
    private final CustomerDtoConverter customerDtoConverter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          TransactionService transactionService, AccountDtoConverter converter, CustomerDtoConverter customerDtoConverter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
        this.customerDtoConverter = customerDtoConverter;
    }
    public List<Account> getAll(){

        return accountRepository.findAll();
    }

    public AccountDto createAccount (CreateAccountRequest createAccountRequest){

        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());
        Account account = new Account(customer,createAccountRequest.getInitialCredit(),
                LocalDateTime.now());

        if(createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO)>0){

            Transaction transaction = transactionService.
                    initialMoney(account, createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }


        return converter.convert(accountRepository.save(account));
    }


}
