package com.infoshareacademy.mappers;

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
        int ingredientNumber = 1;
        int measureNumber = 1;
        for (Map.Entry<String, String> ingredientsMap : ingredients.entrySet()) {
            jsonGenerator.writeStringField("strIngredient" + ingredientNumber++, ingredientsMap.getKey());
            jsonGenerator.writeStringField("strMeasure" + measureNumber++, ingredientsMap.getValue());
        }
        jsonGenerator.writeEndObject();
    }
}