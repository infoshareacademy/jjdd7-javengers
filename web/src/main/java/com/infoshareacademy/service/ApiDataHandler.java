package com.infoshareacademy.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.RecipeApi;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiDataHandler {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Inject
  private FileParserService fileParserService;

  @Inject
  private ParserService parserService;

  @EJB
  private ApiConsumer apiConsumer;

  public void parseAndLoadDataFormApi(String uri) {
    String recipes = apiConsumer.consumeApi(uri);
    try {
      if (!recipes.equals("{\"drinks\":null}")) {
        JsonNode jsonNode = parserService.getJsonNodeForApiParsing(recipes);
        List<RecipeApi> recipesList = (List<RecipeApi>) parserService.parse(jsonNode);
        fileParserService.loadDataToDatabase(recipesList);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("data form api was saved successfully");
  }
}
