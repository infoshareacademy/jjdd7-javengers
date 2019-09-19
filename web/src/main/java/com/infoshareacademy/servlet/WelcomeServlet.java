package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.service.RecipeService;
import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Transactional
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(StartingPageServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) //why doGet not works?
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String sessionAttributeEmail = (String)req.getSession().getAttribute("UserEmail");


        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (sessionAttributeEmail != null) {
            model.put("UserEmail", sessionAttributeEmail);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
