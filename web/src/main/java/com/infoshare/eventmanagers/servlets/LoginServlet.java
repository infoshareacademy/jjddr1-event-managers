package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.LoginUserDto;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.UserService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Inject
    TemplateProvider templateProvider;

    @Inject
    UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        int userId = userService.loginUser(new LoginUserDto(username, req.getParameter("password")));
        if (userId > 0) {
            HttpSession session = req.getSession();
            session.setAttribute("id", userId);
            resp.sendRedirect("/index.html");

        }


        doGet(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Template template = templateProvider.getTemplate(getServletContext(), "login.ftlh");

        Map<String, Object> model = new HashMap<>();
        String username = req.getParameter("username");
        if (username != null) {
            model.put("error", 1);
            model.put("username", username);
        }
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            resp.setStatus(418);
        }


    }
}
