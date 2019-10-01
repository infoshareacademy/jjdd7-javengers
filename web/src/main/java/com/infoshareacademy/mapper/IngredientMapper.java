package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.domain.entity.Ingredient;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
class IngredientMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  List<Ingredient> mapIngredients(RecipeResponse recipe) {

    List<Ingredient> ingredients = new ArrayList<>();
    recipe.getIngredients().forEach((key, value) -> {
      Ingredient ingredient = new Ingredient();
      ingredient.setName(key);
      ingredient.setMeasure(value);
      ingredients.add(ingredient);
    });
    logger.info("Ingredients of recipe {} were mapped", recipe.toString());
    return ingredients;
  }
}