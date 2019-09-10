package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeApi;
import com.infoshareacademy.domain.entity.Category;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoryMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  public Category mapCategory(RecipeApi recipeApi) {
    Category category = new Category();
    category.setName(recipeApi.getRecipeCategory());
    logger.info("Category was mapped");
    return category;
  }
}
