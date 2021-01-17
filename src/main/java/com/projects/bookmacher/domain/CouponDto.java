package com.projects.bookmacher.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class CouponDto {

    private Long id;
    private BigDecimal value;
    private LocalDateTime date;
    private User user;
//    private List<Event> events = new ArrayList<>();

}
