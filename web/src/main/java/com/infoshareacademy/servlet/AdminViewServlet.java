package com.infoshareacademy.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/admin-view")
public class AdminViewServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(),
                "admin-view.ftlh");

        Map<String, Object> dataModel = new HashMap<>();

        PrintWriter writer = resp.getWriter();
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            logger.info(e.getMessage());
        }
    }
}
