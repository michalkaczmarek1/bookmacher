package com.projects.bookmacher.repository;

import com.projects.bookmacher.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAll();
}
