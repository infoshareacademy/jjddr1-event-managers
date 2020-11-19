package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.EventDto;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.EventService;
import com.infoshare.eventmanagers.services.FavoriteService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    EventService eventService;
    @Inject
    FavoriteService favoriteService;
    @Inject
    TemplateProvider templateProvider;

    /**
     * Default constructor.
     */
    public ListServlet() {
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String startParam = request.getParameter("start");
        String rangeParam = request.getParameter("range");
        int mockId = Integer.parseInt("101");
        Integer start;
        Integer range;
        if (startParam==null) {
            start = 0;
        } else start = Integer.valueOf(startParam);
        if (rangeParam==null) {
            range = 10;
        } else range = Integer.valueOf(rangeParam);

        List<EventDto> events = eventService.getRange(start, range);
        events = favoriteService.setIsFavoriteEventDtoList(events,mockId);
        Long numberOfEvents = eventService.getNumberOfEvents();
        Map<String, Object> root = new HashMap<String, Object>();
        root.put("events", events);
        root.put("start", start);
        root.put("next", start+range);
        root.put("previous", start-range);
        root.put("range", range);
        root.put("numberOfEvents", numberOfEvents);
        root.put("userId",mockId);
        Template template = templateProvider.getTemplate(getServletContext(),"listOfEvents.ftlh");
        Writer out = response.getWriter();
        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
