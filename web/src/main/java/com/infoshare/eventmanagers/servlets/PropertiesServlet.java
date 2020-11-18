package com.infoshare.eventmanagers.servlets;

import com.infoshare.eventmanagers.dto.PropertiesDto;
import com.infoshare.eventmanagers.dto.UserDto;
import com.infoshare.eventmanagers.dto.UserPropertiesDto;
import com.infoshare.eventmanagers.providers.TemplateProvider;
import com.infoshare.eventmanagers.services.PropertiesService;
import com.infoshare.eventmanagers.services.UserService;
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

@WebServlet("/properties")
public class PropertiesServlet extends HttpServlet {

    @Inject
    PropertiesService propertiesService;
    @Inject
    TemplateProvider templateProvider;
    @Inject
    UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("save") != null) {
            UserPropertiesDto userPropertiesDto = new UserPropertiesDto();
            PropertiesDto propertiesDto = new PropertiesDto();

            propertiesDto.setSortingOrder(request.getParameter("sortOrder"));
            propertiesDto.setAscending(Boolean.parseBoolean(request.getParameter("ascending")));
            propertiesDto.setDateFormat(request.getParameter("dateFormat"));

            propertiesService.updateProperties(userPropertiesDto.getPropertiesDto().getId(), propertiesDto);
        } else if (request.getParameter("default") != null) {
            UserPropertiesDto userPropertiesDto = new UserPropertiesDto();
            userPropertiesDto.setPropertiesDto(PropertiesDto.getDefaultPropertiesDto());
            userService.updateUser(userPropertiesDto.getId(), UserPropertiesDto.toUserDto(userPropertiesDto));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "properties.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            template.process(model, response.getWriter());
        } catch (TemplateException e) {
            response.setStatus(418);
        }
    }
}
