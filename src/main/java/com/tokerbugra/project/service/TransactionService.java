package com.tokerbugra.project.service;

import com.tokerbugra.project.model.Account;
import com.tokerbugra.project.model.Transaction;
import com.tokerbugra.project.repository.TransactionRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class TransactionService {

    private Logger logger   = LoggerFactory.getLogger(TransactionService.class);
    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    protected Transaction initialMoney(final Account account, BigDecimal amount){

        return transactionRepository.save(new Transaction(amount,account));
    }







}
