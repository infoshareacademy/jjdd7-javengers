package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.view.IngredientLiveSearchView;
import com.infoshareacademy.service.IngredientService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiIngredientService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private IngredientService ingredientService;

  public List<IngredientLiveSearchView> getLiveSearchIngredient(String name) {
    logger.info("ingredients with " + name + "in it were mapped");
    List<IngredientLiveSearchView> ingredientLiveSearchView = new ArrayList<>();
    ingredientService.findIngredientsForLiveSearch(name).forEach(i -> {
      IngredientLiveSearchView ingredient = new IngredientLiveSearchView();
      ingredient.setName(i);
      ingredientLiveSearchView.add(ingredient);
    });
    return ingredientLiveSearchView;
  }
}
