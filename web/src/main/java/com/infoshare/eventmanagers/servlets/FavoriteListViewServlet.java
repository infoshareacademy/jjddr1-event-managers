package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.FavoriteService;
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
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet("/favoriteList")
public class FavoriteListViewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String TEMPLATE_DIR = "WEB-INF/templates";

    @Inject
    FavoriteService favoriteService;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false) == null) {
            resp.sendRedirect("/index.html");
        }
        resp.setContentType("text/html;charset=UTF-8");
        int start = Integer.parseInt(req.getParameter("start"));
        int range = Integer.parseInt(req.getParameter("range"));
        Integer userId = (Integer) (req.getSession().getAttribute("id"));

        int numberOfFavorites = favoriteService.getNumberOfFavorites(userId);
        List<EventDto> eventDtoList = favoriteService.getRange(userId, start, range);
        eventDtoList = favoriteService.setIsFavoriteEventDtoList(eventDtoList, userId);

        Map<String, Object> root = templateProvider.getDefaultModel(Optional.ofNullable(req.getSession(false)));
        root.put("events", eventDtoList);
        root.put("start", start);
        root.put("next", start + range);
        root.put("previous", start - range);
        root.put("range", range);
        root.put("userId", userId);
        root.put("numberOfFavorites", numberOfFavorites);


        Template template = templateProvider.getTemplate(getServletContext(), "favoriteListView.ftlh");

        try {
            template.process(root, resp.getWriter());
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
