package com.infoshare.eventmanagers.servlets;


import com.infoshare.eventmanagers.model.Event;
import com.infoshare.eventmanagers.repository.Repository;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<Event> events = Repository.eventList;
        PrintWriter writer = response.getWriter();
        writer.println(events.toString());

    }
}
