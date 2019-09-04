package com.infoshareacademy.repository;

import com.infoshareacademy.domain.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {

  private static List<Recipe> recipesList = new ArrayList<>();

  private RecipeRepository() {
  }

  public static List<Recipe> getRecipesList() {
    return recipesList;
  }
}