package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Recipe;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class RecipeMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private IngredientMapper ingredientMapper;

  public Recipe mapRecipes(RecipeApi recipeApi, Category category) {

    Recipe recipe = new Recipe();
    recipe.setId(recipeApi.getId());
    recipe.setName(recipeApi.getName());
    recipe.setDrinkType(recipeApi.getDrinkType());
    recipe.setGlassType(recipeApi.getGlassType());
    recipe.setInstruction(recipeApi.getInstruction());
    recipe.getIngredients().addAll(ingredientMapper.mapIngredients(recipeApi));
    recipe.setModificationDate(recipeApi.getModificationDate());
    recipe.setImageUrl(recipeApi.getImageUrl());
    recipe.setCategory(category);
    recipe.setCustom(false);
    recipe.setApproved(true);
    logger.info("Recipe was mapped");
    return recipe;
  }
}
