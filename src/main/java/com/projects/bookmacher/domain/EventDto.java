package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class EventDto {

    private Long id;
    private int scoreType;
    private LocalDate date;
    private Result result;
//    private List<Coupon> coupons = new ArrayList<>();
}
