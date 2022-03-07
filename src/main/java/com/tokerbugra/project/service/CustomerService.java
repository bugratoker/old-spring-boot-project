package com.tokerbugra.project.service;

import com.tokerbugra.project.dto.CustomerDto;
import com.tokerbugra.project.dto.CustomerDtoConverter;
import com.tokerbugra.project.exception.CustomerNotFoundException;
import com.tokerbugra.project.model.Customer;
import com.tokerbugra.project.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id){

        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("not found"));
    }
    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto2(findCustomerById(customerId));
    }

}
