package com.tokerbugra.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class CreateAccountRequest {

    private String customerId;
    private BigDecimal initialCredit;

}
