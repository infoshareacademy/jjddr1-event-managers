package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.services.FavoriteService;
import com.infoshare.eventmanagers.services.EventService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/favoriteManager")
public class FavoriteManageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String TEMPLATE_DIR = "WEB-INF/templates";

    @Inject
    FavoriteService favoriteService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int favoriteId = Integer.parseInt(req.getParameter("favoriteId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        String action = req.getParameter("action");
        if (action.equals("remove")){
            favoriteService.removeFavorite(userId,favoriteId);
        }
        else if(action.equals("add")){
            favoriteService.addFavorite(userId,favoriteId);
        }

    }
}
