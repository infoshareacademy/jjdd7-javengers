package com.infoshareacademy;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.infoshareacademy.domain.Recipe;

import java.io.IOException;
import java.util.Map;


public class RecipeListSerializer extends JsonSerializer<Recipe> {

    @Override
    public void serialize(Recipe recipe, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

        Map<String, String> ingredients = recipe.getIngredients();

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("idDrink", recipe.getId());
        jsonGenerator.writeStringField("strDrink", recipe.getName());
        jsonGenerator.writeStringField("strInstructions", recipe.getInstruction());
        jsonGenerator.writeStringField("strCategory", recipe.getRecipeCategory());
        jsonGenerator.writeStringField("strAlcoholic", recipe.getDrinkType());
        jsonGenerator.writeStringField("strGlass", recipe.getGlassType());
        jsonGenerator.writeStringField("dateModified", recipe.getModificationDate());

        // there can be serialize to format: all ingredients then its measure

        for (int index = 1; index < 16; index++) {
            index = (char) index;
            for (Map.Entry<String, String> ingredientsMap : ingredients.entrySet()) {
                jsonGenerator.writeStringField("strIngredient" + index, ingredientsMap.getKey());
                jsonGenerator.writeStringField("strMeasure" + index, ingredientsMap.getValue());
            }
        }
        jsonGenerator.writeEndObject();
    }
}