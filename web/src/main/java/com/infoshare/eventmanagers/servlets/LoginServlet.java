package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.providers.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String TEST_USER = "user";
    private static final String TEST_PASSWORD = "password";

    @Inject
    TemplateProvider templateProvider;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("user").equals(TEST_USER) && request.getParameter("password").equals(TEST_PASSWORD)){
            request.getSession().setAttribute("user", request.getParameter("user"));
            response.sendRedirect("/index");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "login.ftlh");

        Map root = new HashMap();

        try {
              template.process(root, response.getWriter());
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }

}
