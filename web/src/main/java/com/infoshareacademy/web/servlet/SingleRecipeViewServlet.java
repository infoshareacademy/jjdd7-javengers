package com.infoshareacademy.web.servlet;

import com.google.common.base.Strings;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.RecipeService;
import com.infoshareacademy.service.statistics.StatisticsService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@WebServlet("/recipe-view")
public class SingleRecipeViewServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
    private TemplateProvider templateProvider;
    @Inject
    private RecipeService recipeService;
    @Inject
    private StatisticsService statisticsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String pU;
        if (req.getParameter("pU") == null || req.getParameter("pU").isEmpty()) {
            pU = req.getHeader("referer");
        } else {
            pU = req.getParameter("pU");
        }

        Long userId = Long.parseLong("2");
        String isAdult = "false";

        for (Cookie c : req.getCookies()) {
            if (c.getName().equals("isAdult")) {
                logger.info("cokie {}", c.getName());
                isAdult = c.getValue();
            }
        }

        String recipeId = req.getParameter("recipeId");
        Long parseToLongRecipeId = Long.parseLong(recipeId);
        Recipe responseRecipeId = recipeService.getRecipeById(parseToLongRecipeId);
        List<Long> longList = new ArrayList<>();
        statisticsService.saveToDB(parseToLongRecipeId, longList);
        String userType = (String) req.getSession().getAttribute("userType");
        if (Strings.isNullOrEmpty(userType)) {
            req.getSession().setAttribute("userType", "guest");
        }

        req.getSession().setAttribute("recipeType", responseRecipeId.getDrinkType());
        boolean isFavourite = recipeService.isFavourite(parseToLongRecipeId, userId);
        Template template = templateProvider.getTemplate(getServletContext(), "recipe-view.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (responseRecipeId != null) {
            model.put("responseRecipeId", responseRecipeId);
            model.put("pU", pU);
            model.put("email", req.getSession().getAttribute("email"));
            model.put("userType", req.getSession().getAttribute("userType"));
            model.put("isFavourite", isFavourite);
            model.put("recipeType", req.getSession().getAttribute("recipeType"));
            model.put("isAdult", isAdult);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }
}
