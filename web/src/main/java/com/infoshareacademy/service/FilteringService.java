package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FilteringService {

    @Inject
    private RecipeDaoBean recipeDaoBean;
    @Inject
    private CategoryDaoBean categoryDaoBean;
    @Inject
    private IngredientDaoBean ingredientDaoBean;
    @Inject
    private RecipeService recipeService;

    List<Recipe> getAllFiltersQuery(List<Long> ids, List<String> names, List<String> types) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<Ingredient> ingredients = ingredientDaoBean.getIngredientsByName(names);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        long namesLength = (names).size();
        return recipeService.findRecipeByCategoryIdAndIngredientAndType(categories, ingredients, namesLength, drinkTypes);
    }

    List<Recipe> getFiltersQueryByCategoryAndType(List<Long> ids, List<String> types) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        return recipeService.findRecipeByCategoryIdAndType(categories, drinkTypes);
    }

    List<Recipe> getFavouritesFiltersQuery(List<Long> ids, List<String> names, List<String> types,
        Long userId) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<Ingredient> ingredients = ingredientDaoBean.getIngredientsByName(names);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        long namesLength = (names).size();
        return recipeService.findFavouriteByCategoryIdAndIngredientAndType(categories, ingredients, namesLength, drinkTypes,  userId);
    }

    List<Recipe> getFavouritesFiltersQueryByCategoryAndType(List<Long> ids, List<String> types,
        Long userId) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        return recipeService.findFavouriteRecipeByCategoryIdAndType(categories, drinkTypes, userId);
    }
}
