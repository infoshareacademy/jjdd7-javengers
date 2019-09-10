package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.api.RecipeApi;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RecipeMapper {
  @EJB
  private IngredientMapper ingredientMapper;

  public Recipe mapRecipes(RecipeApi recipeApi) {

    Recipe recipe = new Recipe();
    recipe.setId(recipeApi.getId());
    recipe.setImageUrlAddress(recipeApi.getImageUrl());
    recipe.setName(recipeApi.getName());
    recipe.setGlassType(recipeApi.getGlassType());
    recipe.setDrinkType(recipeApi.getDrinkType());
    recipe.setInstruction(recipeApi.getInstruction());
    recipe.getIngredients().addAll(ingredientMapper.mapIngredients(recipeApi));
    recipe.setModificationDate(recipeApi.getModificationDate());
    recipe.setCustom(false);
    recipe.setApproved(true);

    return recipe;
  }
}
