package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.Recipe;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecipeDeserializer extends JsonDeserializer<Recipe> {

  @Override
  public Recipe deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    Map<String, String> ingredients = new HashMap<>();

    Recipe recipe = new Recipe();
    JsonNode tree = p.readValueAsTree();

    String[] errors = {"null"};

    for (int index = 1; index < 16; index++) {

      index = (char) index;

      JsonNode ingredientNode = tree.get("strIngredient" + index);

      if (ingredientNode == null) {
        break;
      }

      String trim = ingredientNode.asText().trim();

      for (String error : errors) {

        if (!trim.equals(error) && !trim.isEmpty()) {

          ingredients.put(tree.get("strIngredient" + index).asText().trim(),
              tree.get("strMeasure" + index).asText().trim());
        }
      }
    }

    recipe.setId(tree.get("idDrink").asInt());
    recipe.setName(tree.get("strDrink").asText());
    recipe.setInstruction(tree.get("strInstructions").asText());
    recipe.setRecipeCategory(tree.get("strCategory").asText());
    recipe.setDrinkType(tree.get("strAlcoholic").asText());
    recipe.setGlassType(tree.get("strGlass").asText());
    recipe.setModificationDate(tree.get("dateModified").asText());
    recipe.setIngredients(ingredients);
    return recipe;
  }
}

