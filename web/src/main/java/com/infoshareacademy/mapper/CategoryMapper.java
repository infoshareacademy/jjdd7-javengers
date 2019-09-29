package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.api.RecipeResponse;
import com.infoshareacademy.domain.entity.Category;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CategoryMapper {

  private Logger logger = LoggerFactory.getLogger(getClass().getName());

  @Transactional
  public Category mapCategory(RecipeResponse recipe) {
    Category category = new Category();
    category.setName(recipe.getRecipeCategory());
    logger.info("Category " + category.getName() + " was mapped");
    return category;
  }
}