package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.type.DrinkType;
import org.apache.commons.lang3.NotImplementedException;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DrinkTypeMapper {

  public List<DrinkType> mapDrinkTypes(List<Recipe> recipes) {
    try {
      return null;
    } catch (Exception ex) {
      throw new NotImplementedException("method not implemented jet", ex);
    }
  }
}
