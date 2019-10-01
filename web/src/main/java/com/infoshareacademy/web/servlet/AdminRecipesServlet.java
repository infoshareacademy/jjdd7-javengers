package com.infoshareacademy.web.servlet;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.RecipeService;
import com.infoshareacademy.service.StartingPageService;
import com.infoshareacademy.service.UserService;
import com.infoshareacademy.service.UsersPageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@WebServlet("/superHero/recipes")
public class AdminRecipesServlet extends HttpServlet {

    @Inject
    private TemplateProvider templateProvider;
    @Inject
    RecipeService recipeService;
    @Inject
    StartingPageService startingPageService;
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");
        List<String> pageNumber = Arrays.asList(getParametersList(req, new String[]{"1"}));
        Integer pageNo = Integer.parseInt(pageNumber.get(0));
        List<Recipe> recipesPerPage = startingPageService.getRecipesPerPage(
                pageNo, recipeService.getUnauthorizedRecipes());
        Integer lastPageNo = startingPageService
                .getLastNumberPage(recipeService.getUnauthorizedRecipes());
        Template template = templateProvider.getTemplate(getServletContext(),
                "admin-view-recipe.ftlh");
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("name",req.getSession().getAttribute("name"));
        dataModel.put("recipesList",recipesPerPage);
        dataModel.put("pageNumber", pageNo);
        dataModel.put("lastPageNumber", lastPageNo);
        PrintWriter writer = resp.getWriter();
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            logger.info(e.getMessage());
        }
    }

    private static String[] getParametersList(ServletRequest request, String[] defaultValue) {
        if (request.getParameterValues("page") != null) {
            return request.getParameterValues("page");
        } else {
            return defaultValue;
        }
    }
}
