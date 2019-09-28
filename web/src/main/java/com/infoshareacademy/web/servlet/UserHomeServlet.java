package com.infoshareacademy.web.servlet;

import com.google.common.base.Strings;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.CategoryService;
import com.infoshareacademy.service.FilteringService;
import com.infoshareacademy.service.IngredientService;
import com.infoshareacademy.service.RecipeService;
import com.infoshareacademy.service.StartingPageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/home")
public class UserHomeServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(UserHomeServlet.class.getName());
    @Inject
    private StartingPageService startingPageService;
    @Inject
    private CategoryService categoryService;
    @Inject
    private RecipeService recipeService;
    @Inject
    private IngredientService ingredientService;

    @Inject
    private FilteringService filteringService;

    @Inject
    TemplateProvider templateProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String[] allCheckedCategoriesList = categoryService.getCategoryIds();
        String[] allCheckedTypesList = recipeService.getRecipeTypes().toArray(new String[recipeService.getRecipeTypes().size()]);

        resp.setContentType("text/html;charset=UTF-8");
        List<String> pageNumber = Arrays.asList(getParametersList(req, "page", new String[]{"1"}));
        List<String> checkedCategoriesList = Arrays.asList(getParametersList(req, "categories[]", allCheckedCategoriesList));
        List<String> checkedTypesList = Arrays.asList(getParametersList(req, "types[]", allCheckedTypesList));
        List<String> checkedIngredientsList = Arrays.asList(getParametersList(req, "ingredients[]", new String[]{}));

        String active = req.getParameter("active");

        Integer pageNo = Integer.parseInt(pageNumber.get(0));

        List<Recipe> recipesList = startingPageService.getRecipesPerPage(pageNo, recipeService.getRecipiesList());

        List<Category> categoriesList = categoryService.getCategoriesList();

        List<String> ingredientList = ingredientService.getIngredientsList();

        List<String> typeList = recipeService.getRecipeTypes();

        List<Long> paredToLongCategoriesList = checkedCategoriesList.stream()
                .map(s -> Long.parseLong(s))
                .collect(Collectors.toList());
        List<Recipe> checkedCategoriesAndIngredientsAndTypes;
        if (checkedIngredientsList.size() == 0 || checkedIngredientsList == null || checkedIngredientsList.isEmpty()) {
            checkedCategoriesAndIngredientsAndTypes = filteringService.getFiltersQueryByCategoryAndType(paredToLongCategoriesList, checkedTypesList);
        } else {
            checkedCategoriesAndIngredientsAndTypes = filteringService.getAllFiltersQuery(paredToLongCategoriesList, checkedIngredientsList, checkedTypesList);
        }

        List<Recipe> recipeListPerPage = startingPageService.getRecipesPerPage(pageNo, checkedCategoriesAndIngredientsAndTypes);


        Integer lastPageNumber = startingPageService.getLastNumberPage(checkedCategoriesAndIngredientsAndTypes);

        String userType = (String) req.getSession().getAttribute("userType");
        if (Strings.isNullOrEmpty(userType)) {
            req.getSession().setAttribute("userType", "guest");
        }
        String authorization = (String) req.getSession().getAttribute("authorization");
        if (Strings.isNullOrEmpty(authorization)) {
            req.getSession().setAttribute("authorization", "authorizedAttempt");
        }

        Template template = templateProvider.getTemplate(getServletContext(), "userHome.ftlh");
        Map<String, Object> model = new HashMap<>();
        if (recipesList != null || recipesList.isEmpty() || categoriesList != null
            || categoriesList.isEmpty() || checkedCategoriesAndIngredientsAndTypes != null
            || checkedCategoriesAndIngredientsAndTypes.isEmpty()) {
            model.put("isActive", active);
            model.put("recipeListPerPage", recipeListPerPage);
            model.put("pageNumber", pageNo);
            model.put("lastPageNumber", lastPageNumber);
            model.put("categoryList", categoriesList);
            model.put("categoryListChecked", checkedCategoriesList);
            model.put("ingredientList", ingredientList);
            model.put("ingredientListChecked", checkedIngredientsList);
            model.put("typeListChecked", checkedTypesList);
            model.put("email",req.getSession().getAttribute("email"));
            model.put("userType", req.getSession().getAttribute("userType"));
            model.put("typeList", typeList);
            model.put("authorization", req.getSession().getAttribute("authorization"));
            model.put("name", req.getSession().getAttribute("name"));
        }
        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            logger.error(e.getMessage());
        }
    }

    private static String[] getParametersList(ServletRequest request, String paramName,
        String[] defaultValue) {
        if (request.getParameterValues(paramName) != null) {
            return request.getParameterValues(paramName);
        } else {
            return defaultValue;
        }
    }
}

