package com.projects.bookmacher.controller;

import com.projects.bookmacher.domain.Event;
import com.projects.bookmacher.domain.EventDto;
import com.projects.bookmacher.mapper.EventMapper;
import com.projects.bookmacher.service.DbServiceEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class EventController {

    @Autowired
    private final DbServiceEvent dbServiceEvent;

    @Autowired
    private final EventMapper eventMapper;

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        List<Event> events = dbServiceEvent.getEvents();
        return eventMapper.mapToEventDtos(events);
    }

    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEvent(@RequestBody EventDto eventDto) {
        Event event = eventMapper.mapToEvent(eventDto);
        dbServiceEvent.saveEvent(event);
    }

    @PutMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EventDto updateEvent(@RequestBody EventDto eventDto) {
        return eventMapper.mapToEventDto(
                dbServiceEvent.saveEvent(eventMapper.mapToEvent(eventDto))
        );
    }

    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Long id) {
        dbServiceEvent.deleteEvent(id);
    }

}
