package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.view.RecipeLiveSearchView;
import com.infoshareacademy.dto.RecipeDto;
import com.infoshareacademy.mapper.RecipeEntityToDtoMapper;
import com.infoshareacademy.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiRecipeService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private RecipeService recipeService;

  @EJB
  private RecipeEntityToDtoMapper mapper;

  public List<RecipeLiveSearchView> getLiveSearchRecipe(String nameChars) {
    logger.info("recipes with " + nameChars + "in it were mapped");
    List<RecipeLiveSearchView> recipeLiveSearchViews = new ArrayList<>();
    recipeService.findRecipeForLiveSearch(nameChars).forEach(
        i -> recipeLiveSearchViews.add(mapper.mapRecipeEntityForLiveSearch(i)));
    return recipeLiveSearchViews;
  }

  public List getRecipesList() {
    logger.info("recipes were mapped successfully");
    List<RecipeDto> recipes = new ArrayList<>();
    recipeService.getRecipiesList().forEach(i -> recipes.add(mapper.mapRecipeEntityToDto(i)));
    return recipes;
  }
}
