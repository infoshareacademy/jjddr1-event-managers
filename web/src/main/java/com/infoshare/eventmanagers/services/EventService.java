package com.infoshare.eventmanagers.services;

import com.infoshare.eventmanagers.dao.EventDao;
import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.utils.Utils;

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

    public void updateDatabase(){
        eventDao.saveAll(Utils.saveJsonAsArray("/src/main/resources/events.json"));
    }

    public List<EventDto> getAll(){
        return eventDao.getAll();
    }

    public  List<EventDto> getRange(Integer start, Integer range){
        return eventDao.getRange(start, range);
    }

    public List<EventDto> getRangeSorted(Integer start, Integer range, String sortBy, boolean ascending) {
        return eventDao.getRangeSorted(start, range, sortBy, ascending);
    }

    public Long getNumberOfEvents(){
        return eventDao.getNumberOfEvents();
    }

}