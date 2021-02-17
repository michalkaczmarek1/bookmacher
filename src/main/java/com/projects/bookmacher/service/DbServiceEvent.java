package com.projects.bookmacher.service;

import com.projects.bookmacher.domain.Event;
import com.projects.bookmacher.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbServiceEvent {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Event event) {
        Event eventUpdated = eventRepository.save(event);
        return eventUpdated;
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}
