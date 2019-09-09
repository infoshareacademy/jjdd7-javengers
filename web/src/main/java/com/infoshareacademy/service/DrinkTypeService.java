package com.infoshareacademy.service;

import com.infoshareacademy.domain.DrinkType;
import com.infoshareacademy.domain.api.RecipeApi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class DrinkTypeService {

  @Inject
  ParserService parserService;

  private List<RecipeApi> recipesList =
          (List<RecipeApi>) parserService.parseFile();

  public List<DrinkType> mapDrinkTypes() {
    List<DrinkType> drinkTypeEntityList = new ArrayList<>();
    for (DrinkType dt : drinkTypeEntityList) {

      for (RecipeApi recipeApi : recipesList) {
        if (dt.getName().equals(recipeApi.getDrinkType())) {
          //              dt.getRecipes().add(recipeApi); //TODO
        } else {
          DrinkType drinkType = new DrinkType();
          drinkType.setName(recipeApi.getDrinkType());
          List<RecipeApi> recipesEntityList = new ArrayList<>();
          recipesEntityList.add(recipeApi);
          //       drinkType.setRecipes(recipeApi); //TODO
          drinkTypeEntityList.add(drinkType);
        }
      }
    }

    return drinkTypeEntityList;
  }

}
