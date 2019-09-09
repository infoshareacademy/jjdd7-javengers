package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.RecipeApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecipeDeserializer extends JsonDeserializer<RecipeApi> {

  @Override
  public RecipeApi deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    Map<String, String> ingredients = new HashMap<>();

    RecipeApi recipeApi = new RecipeApi();
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

    recipeApi.setId(tree.get("idDrink").asInt());
    recipeApi.setName(tree.get("strDrink").asText());
    recipeApi.setInstruction(tree.get("strInstructions").asText());
    recipeApi.setRecipeCategory(tree.get("strCategory").asText());
    recipeApi.setDrinkType(tree.get("strAlcoholic").asText());
    recipeApi.setGlassType(tree.get("strGlass").asText());
    recipeApi.setModificationDate(tree.get("dateModified").asText());
    recipeApi.setIngredients(ingredients);
    return recipeApi;
  }
}

