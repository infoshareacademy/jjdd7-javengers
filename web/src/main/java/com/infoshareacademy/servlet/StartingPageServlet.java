package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.RecipeService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;

@WebServlet("/main")
public class StartingPageServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(StartingPageServlet.class.getName());
    @Inject
    RecipeService recipeService;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<String> parameters = Collections.list(req.getParameterNames());
/*        List<String> categoriesValues = Arrays.asList(req.getParameterValues("categories[]"));
        List<String> ingredientsValues = Arrays.asList(req.getParameterValues("ingredients[]"));*/
        List<String> listOptions = Arrays.asList(req.getParameterValues("listOptions[]"));

        List<Recipe> recipe = recipeService.getRecipiesList();
     /*   List<String> categories = recipeService.getAllCategories();
        List<String> ingredients = recipeService.getAllIingredients();*/

        Template template = templateProvider.getTemplate(getServletContext(), "test.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (recipe != null) {
       /*     model.put("categoriesValues", categories);
            model.put("ingredientsValues", ingredients);*/
            model.put("recipe", listOptions);
            model.put("recipeContent", recipe);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }


    }

}


