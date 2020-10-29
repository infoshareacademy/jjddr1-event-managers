package com.infoshare.eventmanagers.servlets;


import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.servlet.EventService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/list")
public class ListServlet extends javax.servlet.http.HttpServlet {
    @Inject
    EventService eventservice;


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
    //TODO: eventService.getAll zwraca błąd: More than one row with the given identifier was found

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<EventDto> eventDtos = eventservice.getAll();
        PrintWriter writer = response.getWriter();
        for (EventDto eventDto : eventDtos) {
            System.out.println(eventDto.toString());
            writer.println(eventDto.toString());
        }
    }
}
