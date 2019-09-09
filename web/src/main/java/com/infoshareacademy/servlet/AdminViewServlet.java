package com.infoshareacademy.servlet;

import com.infoshareacademy.cdi.FileUploadProcessor;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.exception.UserImageNotFound;
import com.infoshareacademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/admin-view")
public class AdminViewServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(AdminViewServlet.class);
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private FileUploadProcessor fileUploadProcessor;


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Template template = templateProvider.getTemplate(getServletContext(),
                "admin-view.ftlh");

        Map<String, Object> dataModel = new HashMap<>();

        PrintWriter writer = resp.getWriter();
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }


}
