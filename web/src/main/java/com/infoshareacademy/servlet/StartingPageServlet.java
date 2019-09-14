package com.infoshareacademy.servlet;

import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.CategoryService;
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
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        resp.setContentType("text/html;charset=UTF-8");
        String pageNumber = Optional.ofNullable(req.getParameter("page")).orElse("1");
//        String recipeName = Optional.ofNullable(req.getParameter("nameChars")).orElse("emptyString");
        List<String> checkedCategoriesList = Optional.ofNullable(Arrays.asList(req.getParameterValues("categories[]"))).orElse(Arrays.asList("-1"));
        List<String> checkedIngredientsList = Optional.ofNullable(Arrays.asList(req.getParameterValues("ingredients[]"))).orElse(Arrays.asList("emptyString"));
        List<String> checkedListOptions = Optional.ofNullable(Arrays.asList(req.getParameterValues("listOptions[]"))).orElse(Arrays.asList("emptyString"));

        Integer pageNo = Integer.parseInt(pageNumber);
        List<Recipe> recipesList = startingPageService.getRecipesPerPage(pageNo);
        List<Recipe> allRecipesList = startingPageService.getRecipeByFilterOption(checkedListOptions.get(0));
        List<Category> categoriesList = categoryService.getCategoriesList();
        List<Long> paredToLongCategoriesList = checkedCategoriesList.stream()
                .map(s -> Long.parseLong(s))
                .collect(Collectors.toList());
//        Recipe recipeByName = recipeService.getRecipeByName(recipeName);


        //     List<String> checkedCategories = recipeService.findRecipeByCategoryId(paredToLongCategoriesList);
        //  List<String> checkedIngredients = recipeService.findRecipeByIngredientId(checkedIngredientsList);
        List<String> checkedCategoriesAndIngredients = recipeService.findRecipeByCategoryIdAndIngredient(paredToLongCategoriesList, checkedIngredientsList);


        Template template = templateProvider.getTemplate(getServletContext(), "home.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (recipesList != null || recipesList.isEmpty() || categoriesList != null || categoriesList.isEmpty() || checkedCategoriesAndIngredients != null || checkedCategoriesAndIngredients.isEmpty()) {
            model.put("recipes", recipesList);
            model.put("categoryList", categoriesList);
            model.put("allRecipesList", allRecipesList);
//            model.put("recipeName", recipeByName);
            model.put("checkedCategoriesAndIngredients", checkedCategoriesAndIngredients);
            //    model.put("checkedCategories", checkedCategories);
        }

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.severe(e.getMessage());
        }


    }

}


