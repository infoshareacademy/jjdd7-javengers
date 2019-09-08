package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.IngredientMeasure;
import com.infoshareacademy.domain.api.Recipe;
import com.infoshareacademy.service.ParserService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.lang3.NotImplementedException;

@Stateless
public class IngredientMeasureMapper {

  @Inject
  ParserService parserService;

  private List<Recipe> recipesList =
      (List<Recipe>) parserService.parseFile();

  public List<IngredientMeasure> mapIngredientMeasures(){
    try {
      return null;
    } catch (Exception ex) {
      throw new NotImplementedException("method not implemented jet", ex);
    }
  }
}
