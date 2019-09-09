package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.api.RecipeApi;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryMapper {

  @EJB
  private CategoryDaoBean categoryDaoBean;

  @EJB
  private RecipeMapper recipeMapper;

  public Category mapCategory(RecipeApi recipeApi) {

    Category category = new Category();
    String name = recipeApi.getRecipeCategory();
    //Is there a problem like nullPointerException??
    Category categoryByName = categoryDaoBean.findCategoryByName(name);

    if (categoryByName == null) {
      category.setName(name);
      category.setRecipes(new ArrayList<>());
      category.getRecipes().add(recipeMapper.mapRecipes(recipeApi));
      categoryDaoBean.addCategory(category);
    } else {
      categoryByName.getRecipes().add(recipeMapper.mapRecipes(recipeApi));
      categoryDaoBean.editCategory(categoryByName);
      return categoryByName;
    }
    return category;
  }
}
