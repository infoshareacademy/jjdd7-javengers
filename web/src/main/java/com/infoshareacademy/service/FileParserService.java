package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.mapper.CategoryMapper;
import com.infoshareacademy.mapper.RecipeMapper;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class FileParserService {

    @Inject
    private ParserService parserService;

    @EJB
    private RecipeMapper recipeMapper;

    @EJB
    private CategoryMapper categoryMapper;

    @EJB
    private CategoryDaoBean categoryDaoBean;

    public void parseSaveFileAndData(){
        List<RecipeApi> recipes = (List<RecipeApi>) parserService.parseFile("/home/daria/Downloads/drinks.json");
        for (RecipeApi recipe : recipes) {
//            Category category = categoryMapper.mapCategory(recipe);
            Category category = Optional.ofNullable(categoryDaoBean.findCategoryByName(recipe.getRecipeCategory()))
                    .orElseGet(() -> categoryMapper.mapCategory(recipe));

//            categoryDaoBean.editCategory(category);


            category.getRecipes().add(recipeMapper.mapRecipes(recipe));
            categoryDaoBean.editCategory(category);
        }
    }
}
