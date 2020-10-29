package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "/one")
public class OneEventViewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EventDto> eventDtos = Utils.saveJsonAsArray("/home/krzysztof/Desktop/code/jjddr1-event-managers/web/src/main/resources/events.json");
        PrintWriter writer = response.getWriter();
        for (EventDto eventDto : eventDtos) {
            writer.println(writer);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
