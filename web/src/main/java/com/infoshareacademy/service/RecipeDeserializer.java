package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.RecipeResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecipeDeserializer extends JsonDeserializer<RecipeResponse> {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final String SETTINGS_FILE_NAME = "settings.properties";
  private static final String DATE_FORMAT = "date.format";

  @Override
  public RecipeResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

    Map<String, String> ingredients = new HashMap<>();
    RecipeResponse drinkRecipe = new RecipeResponse();
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

          ingredients.put(tree.get("strIngredient" + index).asText().trim().toLowerCase(),
              tree.get("strMeasure" + index).asText().trim().toLowerCase());
        }
      }
    }
    drinkRecipe.setId(tree.get("idDrink").asLong());
    drinkRecipe.setName(tree.get("strDrink").asText().toLowerCase());
    drinkRecipe.setInstruction(tree.get("strInstructions").asText().toLowerCase());
    drinkRecipe.setRecipeCategory(tree.get("strCategory").asText().toLowerCase());
    drinkRecipe.setDrinkType(tree.get("strAlcoholic").asText().toLowerCase());
    drinkRecipe.setGlassType(tree.get("strGlass").asText().toLowerCase());
    if ((tree.get("dateModified")).isNull()) {
      String datePattern = getDatePattern();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
      drinkRecipe.setModificationDate(LocalDateTime.now().format(formatter));
    } else {
      drinkRecipe.setModificationDate(tree.get("dateModified").asText());
    }
    drinkRecipe.setImageUrl(tree.get("strDrinkThumb").asText());
    drinkRecipe.setIngredients(ingredients);
    return drinkRecipe;
  }

  private String getDatePattern() throws IOException {
    Properties settings = new Properties();
    settings.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(SETTINGS_FILE_NAME))
        .openStream());
    String dateFormat = settings.getProperty(DATE_FORMAT);
    logger.info("Date Time format is: " + dateFormat);
    return dateFormat;
  }
}

