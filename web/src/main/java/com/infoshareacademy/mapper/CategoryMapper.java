package com.infoshareacademy.mapper;

import com.infoshareacademy.dao.CategoryDaoBean;
import com.infoshareacademy.domain.Category;
import com.infoshareacademy.domain.api.RecipeApi;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryMapper {

  @EJB
  private CategoryDaoBean categoryDaoBean;

  @EJB
  private RecipeMapper recipeMapper;

  public Category mapCategory(RecipeApi recipeApi) {

//    Category category = Optional.ofNullable(categoryDaoBean
//            .findCategoryByName(recipeApi.getRecipeCategory())).orElseGet(() -> new Category());
    Category category = new Category();
    category.setName(recipeApi.getName());
    return category;

//    Category category = new Category();
//    String name = recipeApi.getRecipeCategory();
//    List<Category> categoryByName = categoryDaoBean.findCategoryByName(name);
//
//    if (categoryByName.isEmpty()) {
//      category.setName(name);
//      categoryDaoBean.addCategory(category);
//    } else if (categoryByName.size() == 1) {
//      Category a = categoryByName.get(0);
//      categoryDaoBean.editCategory(a);
//      return a;
//    } else {
//      todo redirect to error page
//    }
//    return category;
  }
}
