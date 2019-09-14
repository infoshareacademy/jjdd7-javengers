package com.infoshareacademy.service;

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

    public Integer getLastNumberPage(List<Recipe> recipeList){
       int pageSize = 10;
        return (recipeList.size() + pageSize - 1) / pageSize;
    }


    public List<Recipe> getRecipeByFilterOption(String filterOption) {
        List<Recipe> result = new ArrayList<>();
        String allRecipies = "All Drinks";
        if (filterOption == allRecipies) {
            result = recipeService.getRecipiesList();
        }
        return result;
    }
}





