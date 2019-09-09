package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.RecipeDaoBean;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.api.RecipeApi;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RecipeMapper {

  @EJB
  private CategoryMapper categoryMapper;

  @EJB
  private IngredientMapper ingredientMapper;

  @EJB
  private RecipeDaoBean recipeDaoBean;

  public Recipe mapRecipes(RecipeApi recipeApi) {

    Recipe recipe = new Recipe();
    recipe.setName(recipe.getName());
    recipe.setCategory(categoryMapper.mapCategory(recipeApi));
    recipe.setGlassType(recipeApi.getGlassType());
    recipe.setDrinkType(recipeApi.getDrinkType());
    recipe.setInstruction(recipeApi.getInstruction());
    recipe.setIngredients(ingredientMapper.mapIngredients(recipeApi));
    recipe.setModificationDate(recipeApi.getModificationDate());
    recipe.setCustom(false);
    recipe.setApproved(true);
    recipeDaoBean.addRecipe(recipe);
    return recipe;
  }
}
