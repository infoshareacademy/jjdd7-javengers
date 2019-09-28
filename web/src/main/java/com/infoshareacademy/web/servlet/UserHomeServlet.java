package com.infoshareacademy.web.servlet;

import com.google.common.base.Strings;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.service.*;
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
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

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
    private UserService userService;
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
        List<String> checkedOptionList = Arrays.asList(getParametersList(req, "listOptions[]", new String[]{"All Drinks"}));
        List<String> favouriteIdList = Arrays.asList(getParametersList(req, "favToChangeId", new String[]{"0"}));
        Long userId = (Long) req.getSession().getAttribute("userId");

        Integer pageNo = Integer.parseInt(pageNumber.get(0));
        String checkedListOption = checkedOptionList.get(0);
        Long favouriteId = Long.parseLong(favouriteIdList.get(0));

        //do zmiany na razie zamockowane zeby dzialaly favourites
        /*Long userId = Long.parseLong();*/

        List<Category> categoriesList = categoryService.getCategoriesList();

        List<String> ingredientList = ingredientService.getIngredientsList();
        List<String> typeList = recipeService.getRecipeTypes();



        List<Long> parsedToLongCategoriesList = checkedCategoriesList.stream()
                .map(s -> Long.parseLong(s))
                .collect(Collectors.toList());
        List<Recipe> checkedCategoriesAndIngredientsAndTypes;


        checkedCategoriesAndIngredientsAndTypes = startingPageService.filterContentList(checkedOptionList, checkedIngredientsList, parsedToLongCategoriesList, checkedTypesList, userId);


        List<Recipe> recipeListPerPage = startingPageService.getRecipesPerPage(pageNo, checkedCategoriesAndIngredientsAndTypes);


        List<Long> favouriteRecipeIdsFromUser = recipeService.getFavouritesListIdsForUser(userId);


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
        if (categoriesList != null || categoriesList.isEmpty() || checkedCategoriesAndIngredientsAndTypes != null || checkedCategoriesAndIngredientsAndTypes.isEmpty()) {
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
            model.put("checkedListOption", checkedListOption);
            model.put("favouritesIdsChecked", favouriteRecipeIdsFromUser);
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


