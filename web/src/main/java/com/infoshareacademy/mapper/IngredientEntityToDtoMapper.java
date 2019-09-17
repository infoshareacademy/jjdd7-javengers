package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.view.IngredientLiveSearchView;
import com.infoshareacademy.dto.IngredientDto;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class IngredientEntityToDtoMapper {

  public IngredientDto mapIngredientEntityToDto(Ingredient ingredient) {

    IngredientDto ingredientDto = new IngredientDto();
    ingredientDto.setName(ingredient.getName());
    ingredientDto.setMeasure(ingredient.getMeasure());
    return ingredientDto;
  }

  public IngredientLiveSearchView mapEntityToLiveSearchIngredient(Ingredient ingredient) {

    IngredientLiveSearchView ingredientLiveSearch = new IngredientLiveSearchView();
    ingredientLiveSearch.setName(ingredient.getName());
    return ingredientLiveSearch;
  }
}
