package com.infoshareacademy.mapper;

import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.api.RecipeApi;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class CategoryMapper {

  public Category mapCategory(RecipeApi recipeApi) {
    Category category = new Category();
    category.setName(recipeApi.getRecipeCategory());
    return category;
  }
}
