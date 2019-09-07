package com.infoshareacademy.servlet;


import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import testClass.Category;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/drinks")
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



        List<Category> categoryList = Arrays.asList(
                new Category(1, "Shots"),
                new Category(2, "Cocktails" ),
                new Category(3, "Party Drink" )
                );

        List<String> categoryListChecked = new ArrayList<>();
        categoryListChecked.add("1");
        categoryListChecked.add("3");

            model.put("categoryList", categoryList);
            model.put("categoryListChecked", categoryListChecked);



        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            logger.error("this is error logger");
        }
    }
}


