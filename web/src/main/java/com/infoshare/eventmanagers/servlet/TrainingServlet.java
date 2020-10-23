package com.infoshare.eventmanagers.servlet;

import com.infoshare.eventmanagers.dao.EventDao;
import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.utils.Utils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

        printWriter.println("Hello");


    }
}
