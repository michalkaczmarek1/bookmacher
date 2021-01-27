package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String firstname;

    @NotNull
    @Column(name = "SURNAME")
    private String lastname;

    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Column(name = "EMAIL")
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @OneToMany(
            targetEntity = Coupon.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Coupon> coupons = new ArrayList<>();

//    public User(String firstname, String lastname, String username, String email) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.username = username;
//        this.email = email;
//    }


    public User(@NotNull String firstname, @NotNull String lastname, @NotNull String username, @NotNull String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.email = email;
    }
}
