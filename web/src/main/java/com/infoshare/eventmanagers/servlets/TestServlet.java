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

@WebServlet("/t")
public class TestServlet extends HttpServlet {


    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "testTemplate.ftlh");

        Map<String, Object> model = new HashMap<>();

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            resp.setStatus(418);
        }

    }
}