package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeResponse;
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

  public Recipe mapRecipes(RecipeResponse recipe, Category category) {

    Recipe drinkRecipe = new Recipe();
    drinkRecipe.setId(recipe.getId());
    drinkRecipe.setName(recipe.getName());
    drinkRecipe.setDrinkType(recipe.getDrinkType());
    drinkRecipe.setGlassType(recipe.getGlassType());
    drinkRecipe.setInstruction(recipe.getInstruction());
    drinkRecipe.getIngredients().addAll(ingredientMapper.mapIngredients(recipe));
    drinkRecipe.setModificationDate(recipe.getModificationDate());
    drinkRecipe.setImageUrl(recipe.getImageUrl());
    drinkRecipe.setCategory(category);
    drinkRecipe.setCustom(false);
    drinkRecipe.setApproved(true);
    logger.info("Recipe " + drinkRecipe.getName() + " was mapped");
    return drinkRecipe;
  }
}
