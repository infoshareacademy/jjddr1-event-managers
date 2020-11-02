package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dao.EventDao;
import com.infoshare.eventmanagers.dto.EventDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class EventService {
    @Inject
    EventDao eventDao;


    public EventDto get(Integer id) {
        return eventDao.getEvent(id);
    }

    public List<EventDto> getAll(){
        return eventDao.getAll();
    }
}