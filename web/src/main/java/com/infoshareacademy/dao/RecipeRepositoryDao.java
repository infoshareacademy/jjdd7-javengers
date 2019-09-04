package com.infoshareacademy.dao;

import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.repository.RecipeRepository;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class RecipeRepositoryDao {

  public void loadRepository(List<Recipe> recipesList) {
      RecipeRepository.getRecipesList().addAll(recipesList);
  }
}
