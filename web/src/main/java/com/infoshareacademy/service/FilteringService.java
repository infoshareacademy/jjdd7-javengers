package com.infoshareacademy.service;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.dao.UserDaoBean;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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
    @Inject
    private StartingPageService startingPageService;
    @Inject
    private UserDaoBean userDaoBean;

    public List<Recipe> getAllFiltersQuery(List<Long> ids, List<String> names, List<String> types) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<Ingredient> ingredients = ingredientDaoBean.getIngredientsByName(names);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        long namesLength = (names).size();
        return recipeService.findRecipeByCategoryIdAndIngredientAndType(categories, ingredients, namesLength, drinkTypes);
    }

    public List<Recipe> getFiltersQueryByCategoryAndType(List<Long> ids, List<String> types) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        return recipeService.findRecipeByCategoryIdAndType(categories, drinkTypes);
    }

    public List<Recipe> getFavouritesFiltersQuery(List<Long> ids, List<String> names, List<String> types, List<Long> favouriteIds) {
        List<Category> categories = categoryDaoBean.getCategoriesById(ids);
        List<Ingredient> ingredients = ingredientDaoBean.getIngredientsByName(names);
        List<String> drinkTypes = recipeDaoBean.getRecipeTypeByName(types);
        List<Recipe> favourites = userDaoBean.getFavouritesList();
        long namesLength = (names).size();
        return recipeService.findFavouriteByCategoryIdAndIngredientAndType(categories, ingredients, namesLength, drinkTypes,favourites);
    }
}
