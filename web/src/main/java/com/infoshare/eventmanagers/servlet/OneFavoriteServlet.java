package com.infoshare.eventmanagers.servlet;

import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.service.FavoriteService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

@WebServlet("/oneFavorite")
public class OneFavoriteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String TEMPLATE_DIR = "WEB-INF/templates";

    @Inject
    FavoriteService favoriteService;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int favoriteId = Integer.parseInt(req.getParameter("favoriteId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        Map<String, Object> root = favoriteService.getMappedFavorite(userId,favoriteId);
        root.put("title","Favorite "+favoriteId);

        Template template = templateProvider.getTemplate(getServletContext(), "oneFavorite.ftlh");

        Writer out = resp.getWriter();
        try {
            template.process(root, out);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
