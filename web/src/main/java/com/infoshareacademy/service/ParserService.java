package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
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

  public JsonNode getJsonNodeForApiParsing(String recipes) throws IOException {
    return mapper.readTree(recipes);
  }

  public JsonNode getJsonNodeForFileParsing(File file) throws IOException {
    return mapper.readTree(file);
  }

  public <T> Object parse(JsonNode jsonNode) throws IOException {
    logger.info("Parse data from file");
    return mapper.readValue(jsonNode.get(JSON_ROOT).toString(),
          new TypeReference<List<RecipeApi>>() {
          });
  }

}
