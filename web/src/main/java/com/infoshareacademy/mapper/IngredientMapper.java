package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.domain.entity.Ingredient;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class IngredientMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<Ingredient> mapIngredients(RecipeResponse recipe) {

    List<Ingredient> ingredients = new ArrayList<>();

    recipe.getIngredients().forEach((key, value) -> {
      Ingredient ingredient = new Ingredient();
      ingredient.setName(key);
      ingredient.setMeasure(value);
      ingredients.add(ingredient);
    });
    logger.info("Ingredients of recipe " + recipe.toString() + " were mapped");
    return ingredients;
  }
}