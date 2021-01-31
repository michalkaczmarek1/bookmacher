package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String number;
    private BigDecimal value;
}
