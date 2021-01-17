package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private int scoreType;

    @NotNull
    private LocalDate date;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "result_id")
    private Result result;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "events")
    private List<Coupon> coupons = new ArrayList<>();

}
