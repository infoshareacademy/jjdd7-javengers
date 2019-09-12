package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.domain.entity.Ingredient;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class IngredientMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public List<Ingredient> mapIngredients(RecipeApi recipeApi) {

    List<Ingredient> ingredients = new ArrayList<>();

    recipeApi.getIngredients().entrySet().forEach(i -> {
      Ingredient ingredient = new Ingredient();
      ingredient.setName(i.getKey());
      ingredient.setMeasure(i.getValue());
      ingredients.add(ingredient);
    });
    logger.info("Ingredients were mapped");
    return ingredients;
  }
}
