package com.projects.bookmacher.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public class EventDto {

    private Long id;
    private Integer scoreType;
    private String date;
    private String game;
    private Integer result;
    private List<Coupon> coupons = new ArrayList<>();
}
