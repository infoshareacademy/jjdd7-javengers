

package com.infoshareacademy.Parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MapperStringStringDeserializer extends JsonDeserializer<MapperStringString> {

    private Pattern propertyIngredientPattern = Pattern.compile("^strIngredient[0-9]+$");
    private Pattern propertyMeasurePattern = Pattern.compile("^Measure[0-9]+$");


    @Override
    public MapperStringString deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String ingredientName = null;
        String ingredientMeasure = null;
        Map<String, String> ingredients = new HashMap<>();
        while (p.currentToken() != null) {
            switch (p.currentToken()) {
                case FIELD_NAME:
                    String ingredient = p.getText();
                    Matcher matcher = propertyIngredientPattern.matcher(ingredient);
                    if (matcher.matches()) {
                        ingredientName = (matcher.group(1));
                        //ingredientMeasure = matcher.group(2);
                    }
                    break;
                case VALUE_STRING:
                    if (ingredientName != null && ingredientMeasure != null) {
                        String ingredientValue = ingredients.computeIfAbsent(ingredientName, k -> new HashMap<>());
                        ingredientValue.put(ingredientMeasure, p.getValueAsString());
                        ingredientName = null;
                        ingredientMeasure = null;
                    }
                    break;
                default:
                    break;
            }
            p.nextToken();
        }

        MapperStringString response = new MapperStringString();
        response.setIngredients(ingredients);

        return response;
    }
}

