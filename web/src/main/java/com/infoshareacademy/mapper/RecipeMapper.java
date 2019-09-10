package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.api.RecipeApi;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RecipeMapper {
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
    recipe.setImageUrlAddress(recipeApi.getImageUrl());
    recipe.setCategory(category);
    recipe.setCustom(false);
    recipe.setApproved(true);

    return recipe;
  }
  }
