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
        String email = );
        boolean back = false;

        if (userService.checkEmail(email)) {
            request.setAttribute("emailsIsAlreadyTaken", "1");
            back = true;

        }
        if (userService.checkUsername(username)) {

            request.setAttribute("usernameIsAlreadyTaken", "1");
            request.getParameter("email"            back = true;
        }
        if (back) {
            doGet(request, response);
            return;
        }

        UserDto userDto = new UserDto(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
        if (userService.createUser(userDto)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");
            response.setStatus(201);
            requestDispatcher.forward(request, response);
        } else {
            response.setStatus(500);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "addUser.ftlh");
        Map<String, Object> model = new HashMap<>();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        if (username != null) {
            model.put("username", username);
            if ("1".equals(request.getAttribute("usernameIsAlreadyTaken"))) {
                model.put("usernameIsAlreadyTaken", 1);
            }
        }
        if (email != null) {
            model.put("email", email);
            if ("1".equals(request.getAttribute("emailsIsAlreadyTaken"))) {
                model.put("emailsIsAlreadyTaken", 1);
            }


        }
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            response.setStatus(418);
        }

    }


}
