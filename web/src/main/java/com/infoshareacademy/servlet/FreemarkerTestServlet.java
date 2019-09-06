package com.infoshareacademy.servlet;


import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/test")
public class FreemarkerTestServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(DummyServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");
        Map<String, Object> model = new HashMap<>();
        PrintWriter writer = resp.getWriter();


       /* if (user != null) {

            model.put("user", user);

        } else {
            model.put("errorMessage", "User has not been found.");
        }*/

        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.error("this is error logger");
        }
    }
}


