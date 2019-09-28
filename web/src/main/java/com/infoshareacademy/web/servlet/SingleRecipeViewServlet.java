package com.infoshareacademy.web.servlet;

import com.google.common.base.Strings;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.RecipeService;
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
@WebServlet("/recipe-view")
public class SingleRecipeViewServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Inject
    private RecipeService recipeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String pU =  req.getHeader("referer");
        String recipeId = req.getParameter("recipeId");
        Long parseToLongRecipeId = Long.parseLong(recipeId);
        Recipe responseRecipeId = recipeService.getRecipeById(parseToLongRecipeId);
        String userType = (String) req.getSession().getAttribute("userType");
        if (Strings.isNullOrEmpty(userType)){
            req.getSession().setAttribute("userType", "guest");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "recipe-view.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (responseRecipeId != null) {
            model.put("responseRecipeId", responseRecipeId);
            model.put("pU", pU);
            model.put("email", req.getSession().getAttribute("email"));
            model.put("userType", req.getSession().getAttribute("userType"));
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
