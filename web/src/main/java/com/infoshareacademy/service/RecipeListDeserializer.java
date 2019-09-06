package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.RecipeWithJsonAnnotations;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecipeListDeserializer extends JsonDeserializer<RecipeWithJsonAnnotations> {

  @Override
  public RecipeWithJsonAnnotations deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    Map<String, String> ingredients = new HashMap<>();

    RecipeWithJsonAnnotations recipeWithJsonAnnotations = new RecipeWithJsonAnnotations();
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

    recipeWithJsonAnnotations.setId(tree.get("idDrink").asInt());
    recipeWithJsonAnnotations.setName(tree.get("strDrink").asText());
    recipeWithJsonAnnotations.setInstruction(tree.get("strInstructions").asText());
    recipeWithJsonAnnotations.setRecipeCategory(tree.get("strCategory").asText());
    recipeWithJsonAnnotations.setDrinkType(tree.get("strAlcoholic").asText());
    recipeWithJsonAnnotations.setGlassType(tree.get("strGlass").asText());
    recipeWithJsonAnnotations.setModificationDate(tree.get("dateModified").asText());
    recipeWithJsonAnnotations.setIngredients(ingredients);
    return recipeWithJsonAnnotations;
  }
}

