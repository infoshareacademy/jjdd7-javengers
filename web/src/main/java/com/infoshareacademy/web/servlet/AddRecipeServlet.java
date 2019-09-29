package com.infoshareacademy.web.servlet;


import com.infoshareacademy.FileUpload.FileUploadProcessor;
import com.infoshareacademy.FileUpload.UserImageNotFound;
import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.dto.CategoryDto;
import com.infoshareacademy.dto.IngredientDto;
import com.infoshareacademy.dto.RecipeDto;
import com.infoshareacademy.freemarker.TemplateProvider;
import com.infoshareacademy.mapper.CategoryMapper;
import com.infoshareacademy.mapper.RecipeToAddDtoToEntityMapper;
import com.infoshareacademy.service.CategoryService;
import com.infoshareacademy.service.RecipeService;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Logger;


@Transactional
@WebServlet("/add-recipe-view")
@MultipartConfig
public class AddRecipeServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Inject
    FileUploadProcessor fileUploadProcessor;
    @Inject
    private TemplateProvider templateProvider;

    @Inject
    RecipeToAddDtoToEntityMapper recipeToAddDtoToEntityMapper;

    @EJB
    RecipeService recipeService;

    @EJB
    CategoryService categoryService;

    @EJB
    CategoryMapper categoryMapper;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(),
                "add-recipe-view.ftlh");

        List<Category> categoriesList = categoryService.getCategoriesList();
        List<String> typeList = recipeService.getRecipeTypes();


        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("categoryList", categoriesList);
        dataModel.put("typeList", typeList);


        PrintWriter writer = resp.getWriter();
        try {
            template.process(dataModel, writer);
        } catch (TemplateException e) {
            logger.info(e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {


        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String categoryName = req.getParameter("category");
        String glass = req.getParameter("glass");
        String instructions = req.getParameter("instructions");
        String[] ingredientList = req.getParameterValues("ingredient");
        String[] measuresList = req.getParameterValues("measure");

        /*CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(categoryName);*/

        Map<String, String> ingredients = new HashMap<>();

        for (int i = 0; i < ingredientList.length; i++) {
            ingredients.put(ingredientList[i], measuresList[i]);
        }

        Long idOfRecipe = recipeService.getMaxId();

        RecipeResponse recipe = new RecipeResponse();
        recipe.setId(++idOfRecipe);
        recipe.setName(name);
        recipe.setDrinkType(type);
        recipe.setGlassType(glass);
        recipe.setRecipeCategory(categoryName);
        recipe.setInstruction(instructions);
        recipe.setIngredients(ingredients);

        Part image = req.getPart("image");
        String imageUrl = "";
        try {
            imageUrl = "/images/" + fileUploadProcessor
                    .uploadImageFile(image).getName();
        } catch (UserImageNotFound userImageNotFound) {
            logger.warning(userImageNotFound.getMessage());
        }

        recipe.setImageUrl(imageUrl);


        Category category = Optional
                .ofNullable(categoryService.findCategoryByName(recipe.getRecipeCategory()))
                .orElseGet(() -> categoryMapper.mapCategory(recipe));
        category.getRecipes().add(recipeToAddDtoToEntityMapper.mapRecipe(recipe, category));
        categoryService.updateCategory(category);

        //recipeService.addRecipe(recipeToAddDtoToEntityMapper.mapRecipe(recipe, category));

        resp.getWriter().println("User has been added.");
    }


}
