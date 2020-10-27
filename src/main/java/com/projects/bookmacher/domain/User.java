package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "name")
    private String firstname;

    @NotNull
    @Column(name = "surname")
    private String lastname;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
}
