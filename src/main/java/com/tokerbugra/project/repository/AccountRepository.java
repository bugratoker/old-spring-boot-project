package com.tokerbugra.project.repository;


import com.tokerbugra.project.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {



}
