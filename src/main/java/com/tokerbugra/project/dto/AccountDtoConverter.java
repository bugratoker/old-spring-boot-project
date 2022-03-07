package com.tokerbugra.project.dto;

import com.tokerbugra.project.model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;
    public AccountDtoConverter(TransactionDtoConverter transactionDtoConverter, CustomerDtoConverter customerDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
        this.customerDtoConverter = customerDtoConverter;
    }

    public AccountDto convert(Account from){

        return new AccountDto(from.getId(),
                customerDtoConverter.convertToCustomerDto2(from.getCustomer()),
                from.getBalance(),

                from.getLocalDateTime(),
                from.getTransaction().
                        stream().
                        map(t->transactionDtoConverter.convert(t)).
                        collect(Collectors.toSet())
                );

    }
}
