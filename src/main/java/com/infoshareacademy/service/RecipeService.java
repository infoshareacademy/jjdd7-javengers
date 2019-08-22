package com.infoshareacademy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.infoshareacademy.domain.Recipe;
import com.infoshareacademy.domain.RecipeRepository;
import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class RecipeService {

    public void loadRecipesList() {
        if (RecipeRepository.getRecipesList().isEmpty()) {
            RecipeRepository.getRecipesList().addAll((List<Recipe>) DataParseService.parseFile("drinks.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
    }

    public void loadFavouritesList() {
        if (RecipeRepository.getFavouritesRecipeList().isEmpty()) {
            RecipeRepository.getFavouritesRecipeList().addAll((List<Recipe>) DataParseService.parseFile("favourites.json",
                    new TypeReference<List<Recipe>>() {
                    }, "drinks"));
        }
    }

    public List<Recipe> findRecipeByName(List<Recipe> recipesList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> findRecipeByIngredients(List<Recipe> recipesList, String ingredientName) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> findRecipeByCategory(List<Recipe> recipesList, String recipeCategory) {
        throw new NotImplementedException("Not implemented yet");
    }

    public void addRecipeToList(Recipe recipe) {
        if (!RecipeRepository.getRecipesList().contains(recipe)) {
            RecipeRepository.getRecipesList().add(recipe);
        }
        DataParseToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(),"drink.json");
    }

    public void deleteRecipeFromList(String name) {
        for (Recipe recipe : RecipeRepository.getRecipesList()
        ) {
            if (recipe.getName().equals(name)) {
                RecipeRepository.getRecipesList().remove(recipe);
            }
        }
        DataParseToJsonService.parseJsonToFile(RecipeRepository.getRecipesList(),"drink.json");
    }

    public void editRecipeList(Recipe drinkRecipe, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> addRecipeToFavourites(List<Recipe> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }

    public List<Recipe> deleteRecipeFromFavourites(List<Recipe> favouritesRecipeList, String name) {
        throw new NotImplementedException("Not implemented yet");
    }
}