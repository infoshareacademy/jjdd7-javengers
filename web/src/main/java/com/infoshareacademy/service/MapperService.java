package com.infoshareacademy.service;

import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.mapper.RecipeMapper;
import java.util.List;
import javax.ejb.EJB;

public class MapperService {

  @EJB
  private RecipeMapper recipeMapper;

  public void mapAll(List<RecipeApi>recipes){
    for (RecipeApi recipe: recipes
    ) {
      recipeMapper.mapRecipes(recipe);
    }
  }
}
