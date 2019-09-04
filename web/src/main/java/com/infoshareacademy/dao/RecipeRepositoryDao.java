package com.infoshareacademy.dao;


import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.repository.RecipeRepository;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RecipeRepositoryDao {

  public void loadRepository(List<Recipe> recipesList) {
      RecipeRepository.getRecipesList().addAll(recipesList);
  }
}
