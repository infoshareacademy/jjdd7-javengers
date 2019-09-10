package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Ingredient;
import com.infoshareacademy.domain.api.RecipeApi;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class IngredientMapper {


  public List<Ingredient> mapIngredients(RecipeApi recipeApi) {

    List<Ingredient> ingredients = new ArrayList<>();

    recipeApi.getIngredients().entrySet().forEach(i -> {
      Ingredient ingredient = new Ingredient();
      ingredient.setName(i.getKey());
      ingredient.setMeasure(i.getValue());
      ingredients.add(ingredient);
    });
    return ingredients;
  }
}
