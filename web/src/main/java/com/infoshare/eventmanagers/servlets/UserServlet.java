package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.PropertiesDto;
import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.services.UserService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Inject
    UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDto userDto = new UserDto();
        userService.createUser(userDto);
    }




}
