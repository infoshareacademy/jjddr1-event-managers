package com.infoshare.eventmanagers.servlet;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/manageFavorite")
public class ManageFavoriteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String TEMPLATE_DIR = "WEB-INF/templates";
    private Configuration cfg;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setServletContextForTemplateLoading(getServletContext(), TEMPLATE_DIR);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> root = new HashMap<>();

        Template template = cfg.getTemplate("manageFavorite.ftlh");

        Writer out = resp.getWriter();
        try {
            template.process(root, out);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
