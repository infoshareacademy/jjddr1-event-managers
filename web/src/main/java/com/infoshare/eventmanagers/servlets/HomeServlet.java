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
import java.util.Optional;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");


        Map<String, Object> root = templateProvider.getDefaultModel(Optional.ofNullable(req.getSession(false)));
        try {
            template.process(root, resp.getWriter());
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
