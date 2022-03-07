package com.tokerbugra.project.repository;

import com.tokerbugra.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {




}
