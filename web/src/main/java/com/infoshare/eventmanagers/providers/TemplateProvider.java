package com.infoshare.eventmanagers.providers;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequestScoped
public class TemplateProvider {
    private final String TEMPLATES_DIRECTORY_PATH = "WEB-INF/templates";
    private Configuration configuration;
    @Inject
    private ConfigProvider configProvider;

    public Template getTemplate(ServletContext servletContext, String templateName)
            throws IOException {
        configuration = configProvider.getConfiguration();
        configuration.setServletContextForTemplateLoading(servletContext, TEMPLATES_DIRECTORY_PATH);
        return configuration.getTemplate(templateName);
    }


    public Map<String, Object> getDefaultModel(Optional<HttpSession> session) {
        Map<String, Object> defaultMap = new HashMap<>();
        if (session.isPresent() && session.get().getAttribute("id") != null) {
            defaultMap.put("isLogged", true);
        }

        return defaultMap;
    }

}