package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.view.IngredientLiveSearchView;
import com.infoshareacademy.dto.IngredientDto;
import com.infoshareacademy.mapper.IngredientEntityToDtoMapper;
import com.infoshareacademy.service.IngredientService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiIngredientService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private IngredientService ingredientService;

  @EJB
  private IngredientEntityToDtoMapper mapper;

  @Transactional
  public List<IngredientLiveSearchView> getLiveSearchIngredient(String name) {
    logger.info("ingredients with " + name + "in it were mapped");
    List<IngredientLiveSearchView> ingredientLiveSearchView = new ArrayList<>();
    for (String ingredientName : ingredientService.findIngredientsForLiveSearch(name)) {
      IngredientLiveSearchView ingredient = new IngredientLiveSearchView();
      ingredient.setName(ingredientName);
      ingredientLiveSearchView.add(ingredient);
    }
    return ingredientLiveSearchView;
  }
}
