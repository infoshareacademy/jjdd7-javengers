package com.infoshareacademy.web.servlet;

import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.statistics.StatisticsService;
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

@WebServlet("/superHero/statistics")
public class StatisticsServlet extends HttpServlet {

    @Inject
    private StatisticsService statisticsService;

    @Inject
    private TemplateProvider templateProvider;


    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        PrintWriter printWriter = resp.getWriter();
        Template template = templateProvider.getTemplate(getServletContext(), "contentStatistics.ftlh");

        Map<String, Object> dataModel = new HashMap<>();

        dataModel.put("userType", req.getSession().getAttribute("userType"));


        try {
            template.process(dataModel, printWriter);
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

}
