package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class RecipeService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private RecipeDaoBean recipeDaoBean;

    public Recipe editRecipe(Recipe recipe) {
        logger.info("Recipe update");
        return recipeDaoBean.editRecipe(recipe);
    }

    @Transactional
    public Recipe getRecipeById(Long id) {
        logger.info("Get recipe by id");
        return recipeDaoBean.getRecipeById(id);
    }

    public void deleteRecipeById(Long id) {
        recipeDaoBean.deleteRecipeById(id);
        logger.info("Category has been deleted");
    }

    public List<Recipe> getRecipiesList() {
        logger.info("Get recipies list");
        return recipeDaoBean.getRecipiesList();
    }

    public List<Recipe> findRecipeForLiveSearch(String nameChars) {
        logger.info("recipes with name contains {} found in database", nameChars);
        return recipeDaoBean.findRecipeByLiveSearch(nameChars);
    }

    public List<String> getRecipeTypes() {
        logger.info("Get recipe types");
        return recipeDaoBean.getRecipeTypes();
    }

    List<Recipe> findRecipeByCategoryIdAndIngredientAndType(List<Category> categories,
        List<Ingredient> ingredients, long namesLength, List<String> drinkTypes) {
        return recipeDaoBean.findRecipeByCategoryIdAndIngredientAndType
            (categories, ingredients, namesLength, drinkTypes);
    }

    List<Recipe> findRecipeByCategoryIdAndType(List<Category> categories,
        List<String> drinkTypes) {
        return recipeDaoBean.findRecipeByCategoryIdAndType(categories, drinkTypes);
    }

    List<Recipe> findFavouriteByCategoryIdAndIngredientAndType(List<Category> categories,
        List<Ingredient> ingredients, long namesLength, List<String> drinkTypes, Long userId) {
        return recipeDaoBean.findFavouriteByCategoryIdAndIngredientAndType
            (categories, ingredients, namesLength, drinkTypes, userId);
    }

    List<Recipe> findFavouriteRecipeByCategoryIdAndType(List<Category> categories,
        List<String> drinkTypes, Long userId) {
        return recipeDaoBean.findFavouriteRecipeByCategoryIdAndType(categories, drinkTypes, userId);
    }

    @Transactional
    public List<Long> getFavouritesListIdsForUser(Long userId) {
        return recipeDaoBean.getFavouritesListIds(userId);
    }

    public boolean isFavourite(Long recipeId, Long userId) {
        return recipeDaoBean.getFavouritesListIds(userId).contains(recipeId);
    }

    public Long getMaxId() {
        return recipeDaoBean.getMaxId();
    }
    @Transactional
    public List<Recipe> getUnauthorizedRecipes(){
        return  recipeDaoBean.getUnauthorizedRecipes();
    }
}