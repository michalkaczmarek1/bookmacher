package com.projects.bookmacher.repository;

import com.projects.bookmacher.domain.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ResultRepository extends CrudRepository<Result, Long> {
}
