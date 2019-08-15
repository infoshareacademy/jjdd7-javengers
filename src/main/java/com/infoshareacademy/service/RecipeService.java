package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RecipeService {

    RecipeRepository recipeRepository = new RecipeRepository();
    private List<Recipe> recipesList = recipeRepository.getRecipesList();
    private Set<String> categoriesList = recipeRepository.getCategoriesList();

    public List<Recipe> createRecipesList() {
        DataParseService parser = new DataParseService();
        recipesList = (List<Recipe>) parser.parseFile("drinks.json", new TypeReference<List<Recipe>>() {
        },"drinks");
        return recipesList;
    }

    public Set<String> createCategoriesList(List<Recipe> recipesList) {
        for (Recipe recipe : recipesList) {
            categoriesList.add(recipe.getRecipeCategory());
        }
        return categoriesList;
    }

    public List<Recipe> findRecipeByName(List<Recipe> recipesList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> findRecipeByIngredients(List<Recipe> recipesList, String ingredientName) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> findRecipeByCategory(List<Recipe> recipesList, String recipeCategory) {
        //throw new NotImplementedException("Not implemented yet");
            return
                    recipesList.stream()
                    .filter(r -> r.getRecipeCategory().equals(recipeCategory.trim()))
                            .collect(Collectors.toList());


    }

    public List<Recipe> addRecipeToList(List<Recipe> recipesList, Recipe recipe) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> deleteRecipeFromList(List<Recipe> recipesList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }
}
