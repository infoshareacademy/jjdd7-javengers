package com.infoshareacademy.service;

import com.infoshareacademy.domain.api.RecipeApi;
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
  FileParserService fileParserService;

  @Inject
  ParserService parserService;

  @EJB
  private ApiConsumer apiConsumer;

  public void parseAndLoadDataFormApi() {
    logger.info("data form api was saves to database successfully");
    String recipes = apiConsumer.consumeApi();
    List<RecipeApi> recipesList = (List<RecipeApi>) parserService.parseApiRecipes(recipes);
    fileParserService.loadDataToDatabase(recipesList);
  }
}
