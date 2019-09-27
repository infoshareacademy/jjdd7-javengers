package com.infoshareacademy.service;
import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class RecipeService {
    @PersistenceContext
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private RecipeDaoBean recipeDaoBean;

    public void loadRecipe(List<Recipe> recipes) {
        recipeDaoBean.loadRecipe(recipes);
        logger.info("Recipes list has been loaded");
    }
    public void addRecipe(Recipe recipe) {
        recipeDaoBean.addRecipe(recipe);
        logger.info("Recipe has been saved");
    }
    public Recipe editRecipe(Recipe recipe) {
        logger.info("Recipe update");
        return recipeDaoBean.editRecipe(recipe);
    }
    public Recipe getRecipeByName(String name) {
        logger.info("Get recipe by name");
        return recipeDaoBean.getRecipeByName(name);
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
        /*return recipeDaoBean.getrecipieslist();*/
        return recipeDaoBean.getRecipiesList();
    }
    public List<Recipe> findRecipeByCategoryId(List<Long> ids) {
        return recipeDaoBean.findRecipeByCategoryId(ids);
    }
    public List<String> findRecipeByIngredientId(List<String> names) {
        return recipeDaoBean.findRecipeByIngredientId(names);
    }
    public List<Recipe> findRecipeForLiveSearch(String nameChars) {
        logger.info("recipes with name contains {} found in database", nameChars);
        return recipeDaoBean.findRecipeByLiveSearch(nameChars);
    }

    public List<String> getRecipeTypes() {
        logger.info("Get recipe types");
        return recipeDaoBean.getRecipeTypes();
    }

    public List<Recipe> findRecipeByCategoryIdAndIngredientAndType(List<Category> categories, List<Ingredient> ingredients, long namesLength, List<String> drinkTypes) {
        return recipeDaoBean.findRecipeByCategoryIdAndIngredientAndType(categories, ingredients, namesLength, drinkTypes);
    }

    public List<Recipe> findRecipeByCategoryIdAndType(List<Category> categories, List<String> drinkTypes) {
        return recipeDaoBean.findRecipeByCategoryIdAndType(categories, drinkTypes);
    }

    public List<Recipe> findFavouriteByCategoryIdAndIngredientAndType(List<Category> categories, List<Ingredient> ingredients, long namesLength, List<String> drinkTypes, List<Recipe> favourites) {
        return recipeDaoBean.findFavouriteByCategoryIdAndIngredientAndType(categories, ingredients, namesLength, drinkTypes, favourites);
    }
    @Transactional
    public  List<Long> getFavouritesListIdsForUser(Long userId) {
        return recipeDaoBean.getFavouritesListIds(userId);
    }


}