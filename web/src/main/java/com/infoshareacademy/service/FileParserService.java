package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.mapper.CategoryMapper;
import com.infoshareacademy.mapper.RecipeMapper;
import java.util.List;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class FileParserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private RecipeMapper recipeMapper;

    @EJB
    private CategoryMapper categoryMapper;

    @EJB
    private CategoryDaoBean categoryDaoBean;

    public Object loadDataToDatabase(List<RecipeResponse> recipes) {
        for (RecipeResponse recipe : recipes) {
            Category category = Optional
                .ofNullable(categoryDaoBean.findCategoryByName(recipe.getRecipeCategory()))
                .orElseGet(() -> categoryMapper.mapCategory(recipe));
            category.getRecipes().add(recipeMapper.mapRecipes(recipe, category));
            categoryDaoBean.updateCategory(category);
        }
        logger.info("Recipes " + recipes.toString() + " were saved successfully");
        return null;
    }
}
