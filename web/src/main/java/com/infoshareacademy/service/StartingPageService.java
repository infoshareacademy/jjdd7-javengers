package com.infoshareacademy.service;

import com.infoshareacademy.domain.entity.Category;
import com.infoshareacademy.domain.entity.Ingredient;
import com.infoshareacademy.domain.entity.Recipe;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestScoped
public class StartingPageService {

    @Inject
    RecipeService recipeService;

    public List<Recipe> getRecipesPerPage(int pageNumber) {
        List<Recipe> result = new ArrayList<>();
        List<Recipe> recipeList = recipeService.getRecipiesList();
        int pageSize = 10;

        if (pageSize <= 0 || pageNumber <= 0) {
            throw new IllegalArgumentException("invalid page size: " + pageSize);
        }
        int fromIndex = (pageNumber - 1) * pageSize;
        if (recipeList == null || recipeList.size() < fromIndex) {
            return Collections.emptyList();
        }
        return recipeList.subList(fromIndex, Math.min(fromIndex + pageSize, recipeList.size()));
    }

  /*  public List<Recipe> findRecibyByFilters(List<Category> checkedCategoryList, List<Ingredient> checkedIngredientList, List<Recipe> recipeList){

    }*/
}






