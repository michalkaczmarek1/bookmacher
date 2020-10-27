package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String number;
}
