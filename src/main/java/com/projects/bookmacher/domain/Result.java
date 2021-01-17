package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RESULTS")
public class Result {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private int score;


}
