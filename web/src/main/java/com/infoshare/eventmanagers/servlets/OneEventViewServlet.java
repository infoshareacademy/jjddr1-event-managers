package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.servlet.EventService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/one")
public class OneEventViewServlet extends HttpServlet {
    @Inject
    EventService eventService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestParameter = request.getParameter("id");
        if (requestParameter != null) {
            Integer id = Integer.parseInt(requestParameter);
            EventDto eventDto = eventService.get(id);
            PrintWriter writer = response.getWriter();
            writer.println(eventDto.toString());
        }
    }
}
