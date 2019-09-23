package com.infoshareacademy.service;

import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.domain.entity.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class IngredientService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @EJB
    private IngredientDaoBean ingredientDaoBean;

    public void loadIngredient(List<Ingredient> ingredients) {
        ingredientDaoBean.loadIngredient(ingredients);
        logger.info("Recipe ingredients list has been loaded");
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientDaoBean.addIngredient(ingredient);
        logger.info("Recipe ingredient has been saved");
    }

    public Ingredient editIngredient(Ingredient ingredient) {
        return ingredientDaoBean.editIngredient(ingredient);
    }

    public Ingredient getIngredientByName(String name) {
        logger.info("Get recipe ingredient by name");
        return ingredientDaoBean.getIngredientByName(name);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientDaoBean.getIngredientById(id);
    }

    public void deleteCategoryById(Long id) {
        ingredientDaoBean.deleteCategoryById(id);
    }

    public Ingredient findIngredient(String name) {
        return ingredientDaoBean.findIngredient(name);
    }

    public List<String> getIngredientsList() {
        return ingredientDaoBean.getIngredientsList();
    }

    public List<String> findIngredientsForLiveSearch(String nameChars) {
        logger.info("ingredients with name contains " + nameChars + " found in database");
        return ingredientDaoBean.findIngredientsByLiveSearch(nameChars);
    }

    public List<String> findIngredientsByLiveSearch(String nameChars) {
        return ingredientDaoBean.findIngredientsByLiveSearch(nameChars);
    }

    public List<Ingredient> getIngredientsByName(List<String> names) {
        return ingredientDaoBean.getIngredientsByName(names);
    }
}