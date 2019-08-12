

package com.infoshareacademy;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


class MapperStringStringDeserializer extends JsonDeserializer<RecipeDTO> {

    @Override
    public RecipeDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        Map<String, String> ingredients = new HashMap<>();

        RecipeDTO recipeDTO = new RecipeDTO();
        JsonNode tree = p.readValueAsTree();

        String[] errors = {"null"};

        for (int index = 1; index < 16; index++) {

            index = (char) index;

            for (String error : errors) {

                String trim = tree.get("strIngredient" + index).asText().trim();

                if (!trim.equals(error) && !trim.isEmpty()) {

                    ingredients.put(tree.get("strIngredient" + index).asText().trim(), tree.get("strMeasure" + index).asText().trim());
                }
            }
        }

        recipeDTO.setId(tree.get("idDrink").asInt());
        recipeDTO.setName(tree.get("strDrink").asText());
        recipeDTO.setInstruction(tree.get("strInstructions").asText());
        recipeDTO.setRecipeCategory(tree.get("strCategory").asText());
        recipeDTO.setGlassType(tree.get("strGlass").asText());
        recipeDTO.setModificationDate(tree.get("dateModified").asText());
        recipeDTO.setIngredients(ingredients);
        return recipeDTO;
    }
}

