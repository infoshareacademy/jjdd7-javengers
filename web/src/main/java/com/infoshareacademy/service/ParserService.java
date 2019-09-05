package com.infoshareacademy.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshareacademy.domain.RecipeWithJsonAnnotations;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class ParserService {

  public <T> Object parseFile() {

    T outputObject = null;

    ObjectMapper mapper = new ObjectMapper();

    try {
      JsonNode jsonNode = mapper.readTree(new File("/home/daria/KursJava/jjdd7-javengers/drinks.json"));
      outputObject = mapper.readValue(jsonNode.get("drinks").toString(),
          new TypeReference<List<RecipeWithJsonAnnotations>>() {});
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
