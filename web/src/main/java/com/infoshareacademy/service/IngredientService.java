package com.infoshareacademy.service;

import com.infoshareacademy.dao.IngredientDaoBean;
import com.infoshareacademy.domain.Ingredient;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;

@RequestScoped
public class IngredientService {

  @Inject
  private IngredientDaoBean ingredientDaoBean;

    public void loadIngredient(List<Ingredient> ingredients) {
        ingredientDaoBean.loadIngredient(ingredients);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredientDaoBean.addIngredient(ingredient);
    }

    public Ingredient editIngredient(Ingredient ingredient) {
        return ingredientDaoBean.editIngredient(ingredient);
    }

    public Ingredient getIngredientByName(String name) {
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
