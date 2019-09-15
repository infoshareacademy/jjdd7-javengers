package com.infoshareacademy.service.rest;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.view.RecipeLiveSearchView;
import com.infoshareacademy.dto.RecipeDto;
import com.infoshareacademy.mapper.RecipeEntityToDtoMapper;
import com.infoshareacademy.service.RecipeService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiRecipeService {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @EJB
  private RecipeService recipeService;

  @EJB
  private RecipeEntityToDtoMapper mapper;

  @Transactional
  public List<RecipeLiveSearchView> getLiveSearchRecipe(String nameChars) {
    logger.info("recipes with " + nameChars + "in it were mapped");
    List<RecipeLiveSearchView> recipeLiveSearchViews = new ArrayList<>();
    for (Recipe recipe : recipeService.findRecipeForLiveSearch(nameChars)) {
      recipeLiveSearchViews.add(mapper.mapRecipeEntityForLiveSearch(recipe));
    }
    return recipeLiveSearchViews;
  }

  @Transactional
  public List getRecipesList() {
    logger.info("recipes were mapped successfully");
    List<RecipeDto> recipes = new ArrayList<>();
    for (Recipe recipe : recipeService.getRecipiesList()) {
      recipes.add(mapper.mapRecipeEntityToDto(recipe));
    }
    return recipes;
  }
}
