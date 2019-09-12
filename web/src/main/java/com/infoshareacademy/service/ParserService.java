package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.api.RecipeApi;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class ParserService implements Serializable {

  private static String JSON_ROOT = "drinks";
  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private ObjectMapper mapper = new ObjectMapper();


  public <T> Object parseRecipes(File recipes) {

    T outputObject = null;

    try {
      JsonNode jsonNode = mapper.readTree(recipes);

      outputObject = mapper.readValue(jsonNode.get(JSON_ROOT).toString(),
          new TypeReference<List<RecipeApi>>() {
          });
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("Parse data from file");
    return outputObject;
  }

  public <T> Object parseApiRecipes(String recipes){

    T outputObject = null;

    try {
      JsonNode jsonNode = mapper.readTree(recipes);

      outputObject = mapper.readValue(jsonNode.get(JSON_ROOT).toString(),
          new TypeReference<List<RecipeApi>>() {
          });
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("Parse data from file");
    return outputObject;
  }
}
