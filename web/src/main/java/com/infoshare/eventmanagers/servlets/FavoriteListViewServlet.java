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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/favoriteList")
public class FavoriteListViewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String TEMPLATE_DIR = "WEB-INF/templates";

    @Inject
    FavoriteService favoriteService;
    @Inject
    TemplateProvider templateProvider;
    @Inject
    EventService eventService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        int start = Integer.parseInt(req.getParameter("start"));
        int range = Integer.parseInt(req.getParameter("range"));

        //List<EventDto> eventDtoList = favoriteService.getRange(userId,start,range);
        List<EventDto> eventDtoList = eventService.getRange(start,range);
        eventDtoList = favoriteService.isFavoriteEventDtoList(eventDtoList,userId);
        Map<String, Object> root = new HashMap<>();
        root.put("events", eventDtoList);
        root.put("start", start);
        root.put("next", start+range);
        root.put("previous", start-range);
        root.put("range", range);
        root.put("userId",userId);

        Template template = templateProvider.getTemplate(getServletContext(), "favoriteListView.ftlh");

        try {
            template.process(root, resp.getWriter());
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
