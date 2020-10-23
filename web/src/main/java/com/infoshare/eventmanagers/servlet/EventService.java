package com.infoshare.eventmanagers.servlet;

import com.infoshare.eventmanagers.dao.EventDao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class EventService {
    @Inject
    EventDao eventDao;

    public void saveAll() {

        eventDao.saveAll();
    }
}