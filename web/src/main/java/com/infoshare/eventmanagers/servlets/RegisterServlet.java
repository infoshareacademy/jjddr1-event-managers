package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    UserService userService;
    @Inject
    TemplateProvider templateProvider;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String username = request.getParameter("username");
        String email = request.getParameter("email");


        if (userService.checkEmail(email)) {
            request.setAttribute("message", "Podany adres email jest już zajęty");
            doGet(request, response);
            return;

        }
        if (userService.checkUsername(username)) {

            request.setAttribute("message", "Podana nazwa użytkownika jest już zajęta");
            doGet(request, response);
            return;
        }
        UserDto userDto = new UserDto(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
        userService.createUser(userDto);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");
        requestDispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "addUser.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            response.setStatus(418);
        }

    }


}
