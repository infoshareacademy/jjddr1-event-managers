package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.FavoriteService;
import com.infoshare.eventmanagers.services.EventService;
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

@WebServlet("/favoriteOne")
public class FavoriteOneViewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String TEMPLATE_DIR = "WEB-INF/templates";

    @Inject
    FavoriteService favoriteService;
    @Inject
    EventService eventService;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int favoriteId = Integer.parseInt(req.getParameter("favoriteId"));
        int userId = Integer.parseInt(req.getParameter("userId"));

        EventDto eventDto = favoriteService.getFavorite(userId,favoriteId);

        Map<String, Object> root = new HashMap<>();
        root.put("title","Favorite "+favoriteId);
        root.put("eventDto", eventDto);

        Template template = templateProvider.getTemplate(getServletContext(), "oneEventView.ftlh");

        try {
            template.process(root, resp.getWriter());
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
