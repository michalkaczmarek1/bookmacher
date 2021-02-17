package com.projects.bookmacher.mapper;

import com.projects.bookmacher.domain.Coupon;
import com.projects.bookmacher.domain.CouponDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CouponMapper {

    public Coupon mapToCoupon(CouponDto couponDto) {
        return new Coupon(
                couponDto.getId(),
                couponDto.getValue(),
                couponDto.getDate(),
                couponDto.getUser(),
                couponDto.getEvents()
        );
    }

    public CouponDto mapToCouponDto(Coupon coupon) {
        return new CouponDto(
                coupon.getId(),
                coupon.getValue(),
                coupon.getDate(),
                coupon.getUser(),
                coupon.getEvents()
        );
    }

    public List<CouponDto> mapToCouponDtos(List<Coupon> coupons) {
        return coupons.stream()
                .map(this::mapToCouponDto)
                .collect(Collectors.toList());
    }

}
