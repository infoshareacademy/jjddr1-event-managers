package com.infoshare.eventmanagers.dao;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.models.Event;
import com.infoshare.eventmanagers.models.Organizer;
import com.infoshare.eventmanagers.models.Place;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class EventDao {

    @PersistenceContext
    EntityManager entityManager;

    public Event getById(Integer id) {
        return entityManager.find(Event.class, id);
    }

    @Transactional
    public void saveAll(List<Event> events) {
        for (Event event : events) {


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

    public EventDto getEvent(Integer id) {
        return EventDto.toEventDto(entityManager.find(Event.class, id));
    }

    //TODO: eventService.getAll zwraca błąd: More than one row with the given identifier was found

    public List<EventDto> getAll() {
        TypedQuery<Event> select_e_from_event_e = entityManager.createQuery("SELECT e from Event e", Event.class);
        return select_e_from_event_e.getResultList().stream().map(EventDto::toEventDto).collect(Collectors.toList());
    }

    public List<EventDto> getRange(Integer start, Integer range) {
        TypedQuery<Event> select_e_from_event_e = entityManager.createQuery("SELECT e from Event e", Event.class);
        select_e_from_event_e.setFirstResult(start);
        select_e_from_event_e.setMaxResults(range);
        return select_e_from_event_e.getResultList().stream().map(EventDto::toEventDto).collect(Collectors.toList());

    }

}
