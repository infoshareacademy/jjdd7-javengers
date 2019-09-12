package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.RecipeApi;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import javax.enterprise.context.RequestScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RequestScoped
public class RecipeDeserializer extends JsonDeserializer<RecipeApi> {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

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

          ingredients.put(tree.get("strIngredient" + index).asText().trim().toLowerCase(),
              tree.get("strMeasure" + index).asText().trim().toLowerCase());
        }
      }
    }
    recipeApi.setId(tree.get("idDrink").asLong());
    recipeApi.setName(tree.get("strDrink").asText().toLowerCase());
    recipeApi.setInstruction(tree.get("strInstructions").asText().toLowerCase());
    recipeApi.setRecipeCategory(tree.get("strCategory").asText().toLowerCase());
    recipeApi.setDrinkType(tree.get("strAlcoholic").asText().toLowerCase());
    recipeApi.setGlassType(tree.get("strGlass").asText().toLowerCase());
    if ((tree.get("dateModified")).isNull()) {
      String datePattern = getDatePattern("date.format");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
      recipeApi.setModificationDate(LocalDateTime.now().format(formatter));
    } else {
      recipeApi.setModificationDate(tree.get("dateModified").asText());
    }
    recipeApi.setImageUrl(tree.get("strDrinkThumb").asText());
    recipeApi.setIngredients(ingredients);
    logger.info("Deserialization data from file");
    return recipeApi;
  }

  public String getDatePattern(String property) throws IOException {
    Properties settings = new Properties();
    settings.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource("settings.properties"))
        .openStream());
    return settings.getProperty(property);
  }
}

