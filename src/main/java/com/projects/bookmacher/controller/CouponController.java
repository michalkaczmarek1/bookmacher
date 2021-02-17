package com.projects.bookmacher.controller;

import com.projects.bookmacher.domain.Coupon;
import com.projects.bookmacher.domain.CouponDto;
import com.projects.bookmacher.mapper.CouponMapper;
import com.projects.bookmacher.service.DbServiceCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CouponController {
    @Autowired
    private final DbServiceCoupon dbServiceCoupon;

    @Autowired
    private final CouponMapper couponMapper;

    @GetMapping("/coupons")
    public List<CouponDto> getCoupons() {
        List<Coupon> coupons = dbServiceCoupon.getCoupons();
        return couponMapper.mapToCouponDtos(coupons);
    }

    @GetMapping("/coupons/{id}")
    public CouponDto getCoupon(@PathVariable Long id) {
        Optional<Coupon> coupon = dbServiceCoupon.getCoupon(id);
        return coupon.map(couponMapper::mapToCouponDto).orElse(null);
    }

    @PostMapping(value = "/coupons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCoupon(@RequestBody CouponDto couponDto) {
        Coupon coupon = couponMapper.mapToCoupon(couponDto);
        dbServiceCoupon.saveCoupon(coupon);
    }

    @PutMapping(value = "/coupons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CouponDto updateCoupon(@RequestBody CouponDto couponDto) {
        return couponMapper.mapToCouponDto(
                dbServiceCoupon.saveCoupon(couponMapper.mapToCoupon(couponDto))
        );
    }

    @DeleteMapping("/coupons")
    public void deleteCoupon(@PathVariable Long id) {
        dbServiceCoupon.deleteCoupon(id);
    }

}
