package com.infoshareacademy.repository;

import com.infoshareacademy.domain.RecipeWithJsonAnnotations;
import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {

  private static List<RecipeWithJsonAnnotations> recipesList = new ArrayList<>();

  private RecipeRepository() {
  }

  public static List<RecipeWithJsonAnnotations> getRecipesList() {
    return recipesList;
  }
}