package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NUMBER")
    private String number;

    @NotNull
    private BigDecimal value;

    public Account(@NotNull String number, @NotNull BigDecimal value) {
        this.number = number;
        this.value = value;
    }
}
