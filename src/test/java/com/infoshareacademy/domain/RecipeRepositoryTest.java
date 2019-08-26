package com.infoshareacademy.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
class RecipeRepositoryTest {

  @Test
  void getRecipesList() {

    List<Recipe> recipeList = RecipeRepository.getRecipesList();
    assertThat(recipeList).isNotNull();
    }


  @Test
  void getCategoriesList() {
    List<String> categoriesList = RecipeRepository.getCategoriesList();
    assertThat(categoriesList).isNotNull();
  }

  @Test
  void getIngredientsList() {
  List<String> ingredientsList = RecipeRepository.getIngredientsList();
    assertThat(ingredientsList).isNotNull();

  }

  @Test
  void getFavouritesRecipeList() {
    List<Recipe> favouritiesList = RecipeRepository.getFavouritesRecipeList();
    assertThat(favouritiesList).isNotNull();
  }
}