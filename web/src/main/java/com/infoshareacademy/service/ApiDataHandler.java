package com.infoshareacademy.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.infoshareacademy.domain.api.RecipeResponse;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
class ApiDataHandler {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());
  private static final String NULL_JSON_CONTENT = "{\"drinks\":null}";
  @Inject
  private FileParserService fileParserService;
  @Inject
  private ParserService parserService;
  @EJB
  private ApiConsumer apiConsumer;

  void parseAndLoadDataFormApi(String uri) {
    String jsonContent = apiConsumer.fetchBody(uri);
    try {
      if (!jsonContent.equals(NULL_JSON_CONTENT)) {
        JsonNode jsonNode = parserService.getJsonNodeForApiParsing(jsonContent);
        List<RecipeResponse> recipes = (List<RecipeResponse>) parserService.parse(jsonNode);
        fileParserService.loadDataToDatabase(recipes);
      }
    } catch (IOException e) {
      logger.error("Load data from: {} failed", uri, e);
    }
    logger.info("data form {} was saved successfully", uri);
  }
}
