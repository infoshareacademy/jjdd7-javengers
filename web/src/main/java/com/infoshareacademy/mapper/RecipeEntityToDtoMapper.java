package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.view.RecipeLiveSearchView;
import com.infoshareacademy.dto.IngredientDto;
import com.infoshareacademy.dto.RecipeDto;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RecipeEntityToDtoMapper {

  @EJB
  private CategoryEntityToDtoMapper categoryEntityToDtoMapper;
  @EJB
  private IngredientEntityToDtoMapper ingredientEntityToDtoMapper;

  public RecipeDto mapRecipeEntityToDto(Recipe recipe) {

    RecipeDto recipeDto = new RecipeDto();
    recipeDto.setId(recipe.getId());
    recipeDto.setName(recipe.getName());
    recipeDto.setCategory(categoryEntityToDtoMapper.mapEntityToDto(recipe.getCategory()));
    recipeDto.setDrinkType(recipe.getDrinkType());
    recipeDto.setGlassType(recipe.getGlassType());
    recipeDto.setImageUrlAddress(recipe.getImageUrl());
    recipeDto.setInstruction(recipe.getInstruction());
    recipeDto.setModificationDate(recipe.getModificationDate());
    Map<String, String> ingredientDto = new HashMap<>();
    recipe.getIngredients().forEach(i -> {
      IngredientDto ingredient = ingredientEntityToDtoMapper.mapIngredientEntityToDto(i);
      ingredientDto.put(ingredient.getName(), ingredient.getMeasure());
    });
    recipeDto.setIngredients(ingredientDto);
    return recipeDto;
  }

  public RecipeLiveSearchView mapRecipeEntityForLiveSearch(Recipe recipe) {

    RecipeLiveSearchView liveSearchRecipe = new RecipeLiveSearchView();
    liveSearchRecipe.setId(recipe.getId());
    liveSearchRecipe.setName(recipe.getName());
    return liveSearchRecipe;
  }
}
