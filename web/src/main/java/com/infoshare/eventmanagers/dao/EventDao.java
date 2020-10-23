package com.infoshare.eventmanagers.dao;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.models.Event;
import com.infoshare.eventmanagers.models.Organizer;
import com.infoshare.eventmanagers.models.Place;
import com.infoshare.eventmanagers.utils.Utils;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class EventDao {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public void saveAll() {
        List<EventDto> eventDtos = Utils.saveJsonAsArray("/home/sebastian/Pulpit/kurs/Projekt/jjddr1-event-managers/web/src/main/resources/events.json");

        for (EventDto eventDto : eventDtos) {

            Event event = EventDto.toEvent(eventDto);
            Organizer organizer = entityManager.find(Organizer.class, event.getOrganizer().getId());
            if (organizer != null) {
                event.setOrganizer(organizer);
            }
            Place place = entityManager.find(Place.class, event.getPlace().getId());
            if (place != null) {
                event.setPlace(place);
            }
            entityManager.persist(event);

        }

    }

    public EventDto saveEvent(EventDto eventDto) {
        entityManager.persist(EventDto.toEvent(eventDto));
        return eventDto;
    }

}
