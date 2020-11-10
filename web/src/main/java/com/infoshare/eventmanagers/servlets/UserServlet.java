package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.PropertiesDto;
import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.providers.ConfigProvider;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.UserService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Inject
    UserService userService;
    @Inject
    TemplateProvider templateProvider;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto userDto = new UserDto();
        userService.createUser(userDto);
        //Template template = templateProvider.getTemplate(getServletContext(), "findUserView.ftlh");
        Map<String, Object> model = new HashMap<>();
        UserDto byId = userService.getById(103);
        model.put("User", byId);
        model.put("FavoritsList",byId.getFavoriteList());
        System.out.println(byId);
        System.out.println(byId.getFavoriteList());
//
//        try {
//            template.process(model, response.getWriter());
//        } catch (TemplateException e) {
//            response.setStatus(418);
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Template template = templateProvider.getTemplate(getServletContext(), "addUser.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            response.setStatus(418);
        }

    }




}
