package com.infoshare.eventmanagers.servlets;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/event")
public class TrainingServlet extends HttpServlet {
    @Inject
    EventService eventService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


//        EventDto eventDto = new EventDto();
//        eventDto.setId(1);
//        eventDao.saveEvent(eventDto);
        eventService.saveAll();
        PrintWriter printWriter = resp.getWriter();

        printWriter.println("Rekordy zostały wpisane ");


    }
}
