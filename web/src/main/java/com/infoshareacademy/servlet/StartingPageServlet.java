package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.CategoryService;
import com.infoshareacademy.service.IngredientService;
import com.infoshareacademy.service.RecipeService;
import com.infoshareacademy.service.StartingPageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/home")
public class StartingPageServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(StartingPageServlet.class.getName());
    @Inject
    private StartingPageService startingPageService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private RecipeService recipeService;
    @Inject
    private IngredientService ingredientService;
    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        String pageNumber = Optional.ofNullable(req.getParameter("page")).orElse("1");
        String recipeName = Optional.ofNullable(req.getParameter("nameChars")).orElse(null);
        List<String> checkedCategoriesList = Optional.ofNullable(Arrays.asList(req.getParameterValues("categories[]"))).orElse(new ArrayList<>());
        List<String> checkedIngredientsList = Optional.ofNullable(Arrays.asList(req.getParameterValues("ingredients[]"))).orElse(new ArrayList<>());
        List<String> checkedListOptions = Optional.ofNullable(Arrays.asList(req.getParameterValues("listOptions[]"))).orElse(new ArrayList<>());

        Integer pageNo = Integer.parseInt(pageNumber);
        List<Recipe> recipesList = startingPageService.getRecipesPerPage(pageNo);
        List<Category> categoriesList = categoryService.getCategoriesList();
     //   Recipe recipeByName = recipeService.getRecipeByName(recipeName);

        List<Long> newList = checkedCategoriesList.stream()
                .map(s -> Long.parseLong(s))
                .collect(Collectors.toList());

        List<String> checkedCategories = recipeService.findRecipeByCategoryId(newList);
        List<String> checkedIngredients = recipeService.findRecipeByIngredientId(checkedIngredientsList);


        Template template = templateProvider.getTemplate(getServletContext(), "test.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (recipesList != null || categoriesList != null || checkedCategories != null || checkedIngredients != null) {
            model.put("recipes", recipesList);
            model.put("categories", categoriesList);
        //    model.put("recipeName", recipeByName);
            model.put("checkedCategories", checkedCategories);
            model.put("checkedIngredients", checkedIngredients);

            logger.info("ingredients:" + checkedIngredients);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }


    }

}


