package com.infoshareacademy.service;
import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public List<Recipe> getFavouritesRecipeList(Long recipeId) {
        List<Recipe> favouritesRecipeList = new ArrayList<>();
        Recipe favouriteRecipe = getRecipeById(recipeId);
        if (favouritesRecipeList.contains(favouriteRecipe)) {
            favouritesRecipeList.remove(favouriteRecipe);
        } else {
            favouritesRecipeList.add(favouriteRecipe);
        }
        return favouritesRecipeList;
    }

    public List<Recipe> findRecipeByCategoryIdAndIngredient(List<Long> ids, List<String> names) {
        return recipeDaoBean.findRecipeByCategoryIdAndIngredient(ids, names);
    }


}