package com.tokerbugra.project.dto;

import com.tokerbugra.project.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction transaction){

        return new TransactionDto(
                transaction.getId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate()
        );

    }


}
