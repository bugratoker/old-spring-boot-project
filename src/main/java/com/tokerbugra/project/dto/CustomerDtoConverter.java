package com.tokerbugra.project.dto;

import com.tokerbugra.project.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final AccountDtoConverter accountDtoConverter;

    public CustomerDtoConverter(AccountDtoConverter accountDtoConverter) {
        this.accountDtoConverter = accountDtoConverter;
    }

    public CustomerDto convertToCustomerDto(Customer from){


        return new CustomerDto(from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts().stream().
                        map(account->accountDtoConverter.convert(account)).
                        collect(Collectors.toSet())
                );
    }
    public CustomerDto convertToCustomerDto2(Customer from){


        return new CustomerDto(from.getId(),
                from.getName(),
                from.getSurname()
        );
    }



}
