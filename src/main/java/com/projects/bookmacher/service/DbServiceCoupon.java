package com.projects.bookmacher.service;

import com.projects.bookmacher.domain.Coupon;
import com.projects.bookmacher.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbServiceCoupon {

    @Autowired
    private CouponRepository couponRepository;

    public List<Coupon> getCoupons() {
        return couponRepository.findAll();
    }

    public Optional<Coupon> getCoupon(Long id) {
        return couponRepository.findById(id);
    }

    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }

}
