package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.Recipe;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class RecipeService {

  @EJB
  private RecipeDaoBean recipeDaoBean;

  public void loadRecipe(List<Recipe> recipes) {
    recipeDaoBean.loadRecipe(recipes);
  }

  public void addRecipe(Recipe recipe) {
    recipeDaoBean.addRecipe(recipe);
  }

  public Recipe editRecipe(Recipe recipe) {
    return recipeDaoBean.editRecipe(recipe);
  }

  public Recipe getRecipeByName(String name) {
    return recipeDaoBean.getRecipeByName(name);
  }

  public Recipe getRecipeById(Integer id) {
    return recipeDaoBean.getRecipeById(id);
  }

  public void deleteRecipeById(Integer id) {
    recipeDaoBean.deleteRecipeById(id);
  }

  public List<Recipe> getRecipiesList() {
    return recipeDaoBean.getRecipiesList();
  }
}
