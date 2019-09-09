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
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class ParserService implements Serializable {

  public <T> Object parseFile() {

    T outputObject = null;

    ObjectMapper mapper = new ObjectMapper();

    try {
      JsonNode jsonNode = mapper.readTree(new File("/opt/drinks.json"));
      outputObject = mapper.readValue(jsonNode.get("drinks").toString(),
          new TypeReference<List<RecipeApi>>() {
          });
    } catch (JsonGenerationException e) {
      e.printStackTrace();
    } catch (JsonMappingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return outputObject;
  }
}
