package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.RecipeForParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecipeListDeserializer extends JsonDeserializer<RecipeForParser> {

  @Override
  public RecipeForParser deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    Map<String, String> ingredients = new HashMap<>();

    RecipeForParser recipeForParser = new RecipeForParser();
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

    recipeForParser.setId(tree.get("idDrink").asInt());
    recipeForParser.setName(tree.get("strDrink").asText());
    recipeForParser.setInstruction(tree.get("strInstructions").asText());
    recipeForParser.setRecipeCategory(tree.get("strCategory").asText());
    recipeForParser.setDrinkType(tree.get("strAlcoholic").asText());
    recipeForParser.setGlassType(tree.get("strGlass").asText());
    recipeForParser.setModificationDate(tree.get("dateModified").asText());
    recipeForParser.setIngredients(ingredients);
    return recipeForParser;
  }
}

