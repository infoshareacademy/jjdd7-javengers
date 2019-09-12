package com.infoshareacademy.service;

import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.domain.entity.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class IngredientService {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Inject
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
}
