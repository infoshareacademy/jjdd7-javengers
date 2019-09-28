package com.infoshareacademy.web.servlet;

import com.google.common.base.Strings;
import com.infoshareacademy.freemarker.TemplateProvider;
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

    private static final Logger logger = LoggerFactory.getLogger(WelcomeServlet.class.getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String userType = (String) req.getSession().getAttribute("userType");

        if (Strings.isNullOrEmpty(userType)) {
            req.getSession().setAttribute("userType", "guest");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "index.ftlh");
        Map<String, Object> model = new HashMap<>();
        try {
            model.put("userType", userType);
            model.put("email", req.getSession().getAttribute("email"));
            template.process(model, resp.getWriter());
        } catch (IOException | TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
