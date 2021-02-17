package com.projects.bookmacher.repository;

import com.projects.bookmacher.domain.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CouponRepository extends CrudRepository<Coupon, Long> {
    List<Coupon> findAll();
}
