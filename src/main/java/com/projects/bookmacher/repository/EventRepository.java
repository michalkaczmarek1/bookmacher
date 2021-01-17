package com.projects.bookmacher.repository;

import com.projects.bookmacher.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
}
