package com.infoshareacademy.service;

import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.entity.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class RecipeService {
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

  public Recipe getRecipeById(Long id)
  { logger.info("Get recipe by id");
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

  public List<String> findRecipeByCategoryId(List<Long> ids) {
    return recipeDaoBean.findRecipeByCategory(ids);
  }
}
