package com.infoshareacademy.Parser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Map;

@JsonDeserialize(using = MapperStringStringDeserializer.class)
class MapperStringString {

    private Map<String, String> ingredients;

    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "MapperStringString{" +
                "ingredients=" + ingredients +
                '}';
    }
}