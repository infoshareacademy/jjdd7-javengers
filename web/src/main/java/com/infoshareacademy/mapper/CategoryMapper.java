package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.Recipe;
import org.apache.commons.lang3.NotImplementedException;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CategoryMapper {

  public List<Category> mapDrinkTypes(List<Recipe> recipes) {
    try {
      return null;
    } catch (Exception ex) {
      throw new NotImplementedException("method not implemented jet", ex);
    }
  }
}
