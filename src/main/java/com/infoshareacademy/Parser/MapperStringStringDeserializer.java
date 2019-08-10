

package com.infoshareacademy.Parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;


import java.io.IOException;
import java.util.HashMap;

import java.util.Map;


class MapperStringStringDeserializer extends JsonDeserializer<ParserTest> {

    @Override
    public ParserTest deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        Map<String, String> ingredients = new HashMap<>();

        ParserTest parserTest = new ParserTest();
        JsonNode tree = p.readValueAsTree();

        //errors as String array, if any more errors found later --> add to errors
        String[] errors = {"null"};

        for (int index = 1; index < 16; index++) {

            index = (char) index;


            for (String error : errors) {

                String trim = tree.get("strIngredient" + index).asText().trim();

                if (!trim.equals(error) && !trim.isEmpty()){

                    ingredients.put(tree.get("strIngredient" + index).asText().trim(), tree.get("strMeasure" + index).asText().trim());

                }
            }
        }

        //add all needed
        parserTest.setId(tree.get("idDrink").asText());
        parserTest.setStrDrink(tree.get("strDrink").asText());
        parserTest.setIngredients(ingredients);


        return parserTest;
    }
}

