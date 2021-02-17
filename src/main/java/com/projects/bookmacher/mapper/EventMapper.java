package com.projects.bookmacher.mapper;

import com.projects.bookmacher.domain.Event;
import com.projects.bookmacher.domain.EventDto;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventMapper {

    public Event mapToEvent(EventDto eventDto) {
        return new Event(
                eventDto.getId(),
                eventDto.getScoreType(),
                eventDto.getDate(),
                eventDto.getGame(),
                eventDto.getResult(),
                eventDto.getCoupons()
        );
    }

    public EventDto mapToEventDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getScoreType(),
                event.getDate(),
                event.getGame(),
                event.getResult(),
                event.getCoupons()
        );
    }

    public List<EventDto> mapToEventDtos(List<Event> events) {
        return events.stream()
                .map(this::mapToEventDto)
                .collect(Collectors.toList());
    }

}
